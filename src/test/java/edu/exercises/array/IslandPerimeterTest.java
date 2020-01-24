package edu.exercises.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class IslandPerimeterTest {
    @Parameterized.Parameters
    public static Iterable<Object[]> testData() {
        return newArrayList(new Object[][]{
                {new int[][]{{1}}, 4},
                {new int[][]{{1, 1}}, 6},
                {new int[][]{{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}, 8},
                {new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}, 16}
        });
    }

    @Parameterized.Parameter(0)
    public int[][] grid;
    @Parameterized.Parameter(1)
    public int perimeter;

    @Test
    public void islandPerimeter() {
        assertThat(IslandPerimeter.$(grid)).isEqualTo(perimeter);
    }
}