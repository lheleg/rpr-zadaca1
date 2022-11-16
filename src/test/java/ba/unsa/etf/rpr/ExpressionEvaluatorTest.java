package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionEvaluatorTest {
    ExpressionEvaluator e = new ExpressionEvaluator();

    @Test
    void evaluateTest1() {
        String s = "( ( 1 + 2 ) / ( sqrt 9 ) )";
        assertEquals(1D, e.evaluate(s));
    }

    @Test
    void evaluateTest2() {
        String s = "( ( ( 2 / 4 ) * 3 ) - 1 )";
        assertEquals(0.5D, e.evaluate(s));
    }

    @Test
    void evaluateTest3() {
        String s = "( 1 + ( 2 * ( + ) ) )";
        assertThrows(RuntimeException.class, () -> e.evaluate(s));
    }
}
