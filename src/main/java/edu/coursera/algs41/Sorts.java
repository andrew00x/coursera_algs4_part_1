package edu.coursera.algs41;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import static edu.coursera.algs41.Util.less;

public class Sorts {
    private Sorts() {
        throw new AssertionError();
    }

    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        int length = array.length;
        T[] aux = newArray(length);
        Stopwatch timer = new Stopwatch();
        mergeSort(array, aux, 0, length - 1);
        StdOut.printf("merge sort %d items in %.3f sec\n", array.length, timer.elapsedTime());
    }

    private static <T extends Comparable<T>> void mergeSort(T[] array, T[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int m = lo + (hi - lo) / 2;
        mergeSort(array, aux, lo, m);
        mergeSort(array, aux, m + 1, hi);
        merge(array, aux, lo, m, hi);
    }

    private static <T extends Comparable<T>> void merge(T[] array, T[] aux, int lo, int m, int hi) {
        System.arraycopy(array, lo, aux, lo, hi - lo + 1);
        int i = lo;
        int j = m + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > m) array[k] = aux[j++];
            else if (j > hi) array[k] = aux[i++];
            else if (less(aux[j], aux[i])) array[k] = aux[j++];
            else array[k] = aux[i++];
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> T[] newArray(int size) {
        return (T[]) new Comparable[size];
    }
}
