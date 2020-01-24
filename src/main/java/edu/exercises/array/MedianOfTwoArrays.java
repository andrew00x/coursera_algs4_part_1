package edu.exercises.array;

import static java.util.Arrays.copyOfRange;

public class MedianOfTwoArrays {
    public static int $(int[] arrayOne, int[] arrayTwo) {
        if (arrayOne.length != arrayTwo.length) {
            return -1;
        }
        int arrayLength = arrayOne.length;
        if (arrayLength == 1) {
            return (arrayOne[0] + arrayTwo[0]) / 2;
        }
        int medianOne = getMedian(arrayOne);
        int medianTwo = getMedian(arrayTwo);
        if (medianOne == medianTwo) {
            return medianOne;
        }
        if (medianOne > medianTwo) {
            if (isEven(arrayLength)) {
                return $(copyOfRange(arrayOne, 0, arrayLength / 2), copyOfRange(arrayTwo, arrayLength / 2, arrayLength));
            }
            return $(copyOfRange(arrayOne, 0, arrayLength / 2 + 1), copyOfRange(arrayTwo, arrayLength / 2, arrayLength));
        }
        if (isEven(arrayLength)) {
            return $(copyOfRange(arrayOne, arrayLength / 2, arrayLength), copyOfRange(arrayTwo, 0, arrayLength / 2));
        }
        return $(copyOfRange(arrayOne, arrayLength / 2, arrayLength), copyOfRange(arrayTwo, 0, arrayLength / 2 + 1));
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    private static int getMedian(int[] array) {
        if (isEven(array.length)) {
            return (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        }
        return array[array.length / 2];
    }
}
