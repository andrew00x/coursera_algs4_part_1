package edu.exercises.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class MatrixReshapeTest {
    @Parameterized.Parameters
    public static Iterable<Object[]> testData() {
        return newArrayList(new Object[][] {
                {new int[][]{{1, 2}, {3, 4}}, new int[][]{{1, 2, 3, 4}},         1, 4},
                {new int[][]{{1, 2}, {3, 4}}, new int[][]{{1, 2}, {3, 4}},       2, 4},
                {new int[][]{{1, 2}, {3, 4}}, new int[][]{{1}, {2}, {3}, {4}},   4, 1},
        });
    }

    @Parameterized.Parameter(0)
    public int[][] matrix;
    @Parameterized.Parameter(1)
    public int[][] reshaped;
    @Parameterized.Parameter(2)
    public int rows;
    @Parameterized.Parameter(3)
    public int cols;

    @Test
    public void reshapeMatrix() {
        assertThat(MatrixReshape.$(matrix, rows, cols)).isEqualTo(reshaped);
    }
}