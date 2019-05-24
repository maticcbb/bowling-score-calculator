import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BowlingScoreCalculatorImplTest {

    private BowlingScoreCalculatorImpl bowlingCalculator;

    @BeforeEach
    public void setBowlingCalculator() {
        bowlingCalculator = new BowlingScoreCalculatorImpl();
    }

    @Test
    void canRoll() {
        bowlingCalculator.roll(0);
    }

    @Test
    void canScoreZeroPoints() {
        // When
        roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);

        // Then
        assertThat(bowlingCalculator.score()).isEqualTo(0);
    }

    @Test
    void canScoreGameOfOnes() {
        // When
        roll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);

        // Then
        assertThat(bowlingCalculator.score()).isEqualTo(20);
    }

    @Test
    void canScoreSpareFollowedByFive() {
        // When
        roll(5,5, 5,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);

        // Then
        assertThat(bowlingCalculator.score()).isEqualTo(20);
    }

    @Test
    void canScoreStrikeFollowedByThree() {
        // When
        roll(10,3, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);

        // Then
        assertThat(bowlingCalculator.score()).isEqualTo(22);
    }

    @Test
    void canScoreAllStrikes() {
        // When
        roll(10,10, 10,10, 10,10, 10,10, 10,10, 10,10);

        // Then
        assertThat(bowlingCalculator.score()).isEqualTo(300);
    }

    @Test
    void canCalculateRounds() {
        // When
        roll(10,3, 3,0, 0,0, 0,0, 0,10, 0,0, 3,2, 10,0, 0);

        // Then
        assertThat(bowlingCalculator.round()).isEqualTo(10);
    }

    @Test
    void canCalculateActualRound() {
        // When
        roll(10,3, 3,10, 0,0, 3,2, 10,0, 0);

        // Then
        assertThat(bowlingCalculator.round()).isEqualTo(8);
    }

    @Test
    public void shouldReturnTrueWhenGameIsFinished() {
        // When
        roll(10,10, 10,10, 10,10, 10,10, 10,10, 10,10);

        // Then
        assertThat(bowlingCalculator.isFinished()).isEqualTo(true);

    }

    @Test
    void shouldReturnFalseWhenGameIsNotFinished() {
        //When
        roll(1,2, 5,6, 3,2, 7,3, 2,4 );

        // Then
        assertThat(bowlingCalculator.isFinished()).isEqualTo(false);
    }

    @Test
    void shouldReturnTotalScoreAndThatGameIsFinished() {
        //When
        roll(10, 5,5, 10, 3,2, 5,3, 10, 10, 8,1, 3,5, 10,10,9);

        //Then
        assertThat(bowlingCalculator.score()).isEqualTo(161);
        assertThat(bowlingCalculator.isFinished()).isEqualTo(true);
    }

    @Test
    void shouldReturnActualScoreAndRoundAndThatGameIsNotFinished() {
        //When
        roll(0,0, 5,5, 10, 3,2, 5,3, 8,1, 10, 8,1);

        //Then
        assertThat(bowlingCalculator.score()).isEqualTo(85);
        assertThat(bowlingCalculator.round()).isEqualTo(9);
        assertThat(bowlingCalculator.isFinished()).isEqualTo(false);
    }

    public void roll(int... rolls) {
        for (int pins : rolls) {
            bowlingCalculator.roll(pins);
        }
    }
}
