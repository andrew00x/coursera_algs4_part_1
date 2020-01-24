package edu.exercises.array;

import static java.lang.System.arraycopy;

public class RotateArray {
    public static <T> T[] rotate(T[] array, int pos) {
        int split = array.length - pos;
        reverse(array, 0, split - 1);
        reverse(array, split, array.length - 1);
        reverse(array, 0, array.length - 1);
        return array;
    }

    private static <T> T[] reverse(T[] array, int start, int end) {
        if (array.length < 2) {
            return array;
        }
        while (start < end) {
            swap(array, start, end);
            ++start;
            --end;
        }
        return array;
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static <T> T[] rotate2(T[] array, int pos) {
        T[] tmp = array.clone();
        arraycopy(array, 0, tmp, pos, array.length - pos);
        arraycopy(array, array.length - pos, tmp, 0, pos);
        return tmp;
    }
}
