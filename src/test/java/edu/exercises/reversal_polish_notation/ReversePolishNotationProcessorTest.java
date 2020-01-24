package edu.exercises.reversal_polish_notation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class ReversePolishNotationProcessorTest {
    private ReversePolishNotationProcessor processor;

    @Before
    public void setUp() throws Exception {
        processor = new ReversePolishNotationProcessor();
    }

    @Parameterized.Parameters(name = "When expression is {0}, then result must be {1}")
    public static Iterable<Object[]> testData() {
        return newArrayList(new Object[][]{
                {"2 -", -2.0},
                {"2 3 +", 5.0},
                {"2 3 -", -1.0},
                {"2 3 - -", 1.0},
                {"2 3 *", 6.0},
                {"2 3 ^", 8.0},
                {"10 2 /", 5.0},
                {"10 2 / 3 -", 2.0},
                {"10 2 / 3 + 2 *", 16.0},
                {"5 1 2 + 4 * + 3 - 2 / -", -7.0},
                {"5 1 2 + 4 * + 3 - 2 / - 2 ^", 49.0}
        });
    }

    @Parameterized.Parameter(0)
    public String expression;

    @Parameterized.Parameter(1)
    public double expectedResult;

    @Test
    public void calculatesResultOfReversePolishNotation() {
        double result = processor.calculate(expression);
        assertThat(result).isEqualTo(expectedResult);
    }
}