package edu.coursera.algs41;

class Util {
    private Util() {
        throw new AssertionError();
    }

    static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static <T extends Comparable<T>> boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                if (less(arr[i], arr[i - 1])) return false;
            }
        }
        return true;
    }
}
