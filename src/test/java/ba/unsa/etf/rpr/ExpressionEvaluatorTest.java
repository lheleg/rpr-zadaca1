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
        //incorrect number of operands
        String s = "( 1 + ( 2 * ( + ) ) )";
        assertThrows(RuntimeException.class, () -> e.evaluate(s));
    }

    @Test
    void evaluateTest4() {
        //correct number of parentheses but incorrectly used
        String s = "( 2 + () * 5 )";
        assertThrows(RuntimeException.class, () -> e.evaluate(s));
    }

    @Test
    void evaluateTest5() {
        //test for sqrt
        String s = "( ( sqrt ( 225 ) / 5 ) - 2 )";
        assertEquals(1D, e.evaluate(s));
    }

    @Test
    void evaluateTest6() {
        //empty string
        String s = "";
        assertThrows(RuntimeException.class, () -> e.evaluate(s));
    }
}
