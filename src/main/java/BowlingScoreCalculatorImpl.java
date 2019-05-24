public class BowlingScoreCalculatorImpl implements BowlingScoreCalculator {

    private int roll = 0;
    private int[] rolls = new int[21];

    public void roll(int pins) {
        rolls[roll++] = pins;
    }

    public int score() {
        int score = 0;
        int index = 0;
        for (int frame = 0; frame < 10; frame++){
           if (isSpare(index)){
               score += 10 + rolls[index + 2];
               index += 2;
           }
           else {
               score += rolls[index] + rolls[index + 1];
               index++;
           }
        }

        return score;
    }

    private boolean isSpare(int index) {
      return rolls[index] + rolls[index + 1] == 10;
    }
}
