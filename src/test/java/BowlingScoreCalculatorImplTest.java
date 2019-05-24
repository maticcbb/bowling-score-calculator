import org.junit.jupiter.api.Test;

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
}
