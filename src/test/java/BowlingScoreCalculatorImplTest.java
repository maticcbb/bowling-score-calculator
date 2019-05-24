
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BowlingScoreCalculatorImplTest {

    @Test
    void canMakeBowlingCalculator() {
        new BowlingScoreCalculatorImpl();
    }

    @Test
    void canRoll() {
        BowlingScoreCalculatorImpl bowlingCalculator = new BowlingScoreCalculatorImpl();
        bowlingCalculator.roll(0);

    }

    @Test
    void canScoreZeroPoints() {
        BowlingScoreCalculatorImpl bowlingCalculator = new BowlingScoreCalculatorImpl();
        for (int i = 0; i < 20; i++){
            bowlingCalculator.roll(0);
        }
        assertThat(bowlingCalculator.score()).isEqualTo(0);

    }
}
