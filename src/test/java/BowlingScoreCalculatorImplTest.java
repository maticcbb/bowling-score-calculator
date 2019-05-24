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
        roll( 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertThat(bowlingCalculator.score()).isEqualTo(0);

    }

    @Test
    void canScoreGameOfOnes() {
        roll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);
        assertThat(bowlingCalculator.score()).isEqualTo(1);
    }

    @Test
    void canScoreSpareFollowedByFive() {
        roll(5,5, 5,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertThat(bowlingCalculator.score()).isEqualTo(15);
    }


    private void roll(int...rolls){
        for (int pins : rolls) {
            roll(pins);
        }
    }
}
