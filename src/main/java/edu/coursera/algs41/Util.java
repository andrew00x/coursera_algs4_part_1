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
        return isSorted(arr, 0, arr.length - 1);
    }

    static <T extends Comparable<T>> boolean isSorted(T[] arr, int lo, int hi) {
        if (hi - lo > 1) {
            for (int i = lo + 1; i <= hi ; i++) {
                if (less(arr[i], arr[i - 1])) return false;
            }
        }
        return true;
    }

    static <T extends Comparable<T>> int median(T[] array, int i, int j, int k) {
        return less(array[i], array[j])
                ? less(array[j], array[k]) ? j : less(array[i], array[k]) ? k : i
                : less(array[j], array[k]) ? j : less(array[i], array[k]) ? i : k;
    }
}
