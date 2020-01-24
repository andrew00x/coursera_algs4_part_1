package edu.exercises.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class MedianOfTwoArraysTest {
    @Parameter(0)
    public int[] arrayOne;

    @Parameter(1)
    public int[] arrayTwo;

    @Parameter(2)
    public int result;

    @Parameters
    public static Iterable<Object[]> testData() {
        return newArrayList(new Object[][]{
                {new int[]{1, 2, 4, 6},        new int[]{1, 2, 4, 6},        3},
                {new int[]{1, 12, 15, 26, 38}, new int[]{2, 13, 17, 30, 45}, 16},
                {new int[]{1, 2, 3, 6},        new int[]{4, 6, 8, 10},       5},
                {new int[]{1, 2, 3, 4, 5},     new int[] {2, 3, 4, 5, 6},    3}
        });
    }

    @Test
    public void testMedianOfArrays() throws Exception {
        assertThat(MedianOfTwoArrays.$(arrayOne, arrayTwo)).isEqualTo(result);
    }
}