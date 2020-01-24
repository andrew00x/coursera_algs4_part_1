package edu.exercises.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RotateArrayTest {
    private String[] array = new String[] {"1", "2", "3", "4", "5", "6"};
    private String[] expected = new String[]{"5", "6", "1", "2", "3", "4"};

    @Test
    public void rotatesArray() {
        assertThat(RotateArray.rotate(array, 2)).isEqualTo(expected);
    }

    @Test
    public void rotatesArray2() {
        assertThat(RotateArray.rotate2(array, 2)).isEqualTo(expected);
    }
}