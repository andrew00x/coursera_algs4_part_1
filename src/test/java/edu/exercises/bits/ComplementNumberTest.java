package edu.exercises.bits;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class ComplementNumberTest {
    @Parameterized.Parameters
    public static Iterable<Object[]> testData() {
        return newArrayList(new Object[][]{
                {1,          0},
                {5,          2},
                {6,          1},
                {7,          0},
                {2147483646, 1},
                {2147483647, 0}
        });
    }

    @Parameterized.Parameter(0)
    public int num;
    @Parameterized.Parameter(1)
    public int result;

    @Test
    public void complementNumber() {
        assertThat(ComplementNumber.$(num)).isEqualTo(result);
    }
}