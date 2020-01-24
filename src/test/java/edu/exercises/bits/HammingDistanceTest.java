package edu.exercises.bits;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class HammingDistanceTest {
    @Parameterized.Parameters
    public static Iterable<Object[]> testData() {
        return newArrayList(new Object[][] {
                {1,  4,  2},
                {3,  7,  1},
                {0,  0,  0},
                {10, 10, 0}
        });
    }

    @Parameterized.Parameter(0)
    public int x;
    @Parameterized.Parameter(1)
    public int y;
    @Parameterized.Parameter(2)
    public int result;

    @Test
    public void hammingDistance() {
        assertThat(HammingDistance.$(x, y)).isEqualTo(result);
    }
}