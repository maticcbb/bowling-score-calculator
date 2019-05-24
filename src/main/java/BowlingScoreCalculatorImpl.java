public class BowlingScoreCalculatorImpl implements BowlingScoreCalculator {

    private int roll = 0;
    private int round = 1;
    private int[] rolls = new int[21];
    private int indexCounter = 0;

    @Override
    public void roll(int pins) {
        if (pins >= 0) {
            rolls[roll++] = pins;
        }
    }

    @Override
    public int score() {
        int score = 0;
        int index = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(index)) {
                score += 10 + rolls[index + 1] + rolls[index + 2];
                index++;
            } else if (isSpare(index)) {
                score += 10 + rolls[index + 2];
                index += 2;
            } else {
                score += rolls[index] + rolls[index + 1];
                index += 2;
            }
        }

        return score;
    }

    @Override
    public int round() {
        for (int i = 0; i < roll && round < 10; i++) {
            if (rolls[i] == 10) {
                round++;
            } else {
                i++;
                round++;
            }
            indexCounter = i; //get index before 10 round
        }
        return round;
    }


    @Override
    public boolean isFinished() {

        if (round() == 10) {
            int lastRoundFirstRoll = indexCounter + 1;

            if (isStrike(lastRoundFirstRoll) || isSpare(lastRoundFirstRoll)) {
                return lastRoundFirstRoll + 3 == roll;
            } else {
                return lastRoundFirstRoll + 2 == roll;
            }
        }
        return false;
    }

    private boolean isStrike(int index) {
        return rolls[index] == 10;
    }

    private boolean isSpare(int index) {
        return rolls[index] + rolls[index + 1] == 10;
    }

}
