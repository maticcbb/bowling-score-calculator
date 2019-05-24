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
        for (int i = 0; i < 20; i++) {
            bowlingCalculator.roll(0);
        }
        assertThat(bowlingCalculator.score()).isEqualTo(0);

    }

    @Test
    void canScoreGameOfOnes() {
        for (int i = 0; i < 20; i++) {
            bowlingCalculator.roll(1);
        }
        assertThat(bowlingCalculator.score()).isEqualTo(1);
    }
}
