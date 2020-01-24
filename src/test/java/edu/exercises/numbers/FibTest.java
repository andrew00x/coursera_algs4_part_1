package edu.exercises.numbers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class FibTest {
    @Parameterized.Parameters(name = "When n is {0} then Fib(n) is {1}")
    public static Iterable<Object[]> testData() {
        return newArrayList(
                new Object[][] {
                        {0,   0},
                        {1,   1},
                        {2,   1},
                        {3,   2},
                        {5,   5},
                        {10,  55},
                        {50,  12586269025L},
                        {80, 23416728348467685L}
                }
        );
    }

    @Parameterized.Parameter(0)
    public int num;
    @Parameterized.Parameter(1)
    public long result;

    @Test
    public void fibNumber() {
        assertThat(Fib.f(num)).isEqualTo(result);
    }
}