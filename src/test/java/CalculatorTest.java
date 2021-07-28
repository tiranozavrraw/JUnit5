import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.it_academy.practice.junit_basics.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class CalculatorTest {
    @Test
    public void testDivide() {
        Calculator calculator = new Calculator(10,2);
        assertEquals(calculator.calculate('/'), 5,0 );
    }

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator(10,2);
        assertEquals(calculator.calculate('+'), 12,0 );
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator(10,2);
        assertEquals(calculator.calculate('*'), 20,0 );
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator(10,2);
        assertEquals(calculator.calculate('-'), 8,0 );
    }

    @Test
    public void testExponent() {
        Calculator calculator = new Calculator(10,2);
        assertEquals(calculator.calculate('^'), 100,0 );
    }

    @Test
    public void testRoot() {
        Calculator calculator = new Calculator(100,2);
        assertEquals(calculator.calculate('√'), 10,0 );
    }

    @Test
    public void testDefault() {
        Calculator calculator = new Calculator(10, 2);
        assertEquals(calculator.calculate(' '), 0);
    }


    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testWithParams(int argument1, int argument2, int expectedResult) {
        Calculator calculator = new Calculator(argument1, argument2);
        assertEquals(expectedResult,calculator.calculate('+'));
    }

    @Test
    public void testDivideByZeroException() {
        Calculator calculator = new Calculator(10, 0);
        assertEquals(0, calculator.calculate('/')); // It is a really bad check
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of( 1, 1, 2),
                Arguments.of( 3, 2, 5),
                Arguments.of( 6, 3, 9)
        );
    }
}
