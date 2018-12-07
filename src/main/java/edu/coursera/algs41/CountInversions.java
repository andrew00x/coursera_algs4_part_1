package edu.coursera.algs41;

import static edu.coursera.algs41.Util.less;

public class CountInversions {
    public static <T extends Comparable<T>> int inversions(T[] array) {
        int n = array.length;
        T[] copy = newArray(n);
        System.arraycopy(array, 0, copy, 0, n);
        return sort(copy, newArray(n), 0, n - 1);
    }

    private static <T extends Comparable<T>> int sort(T[] array, T[] aux, int lo, int hi) {
        if (lo >= hi) return 0;
        int m = lo + (hi - lo) / 2;
        int inv = sort(array, aux, lo, m);
        inv += sort(array, aux, m + 1, hi);
        if (less(array[m + 1], array[m])) inv += merge(array, aux, lo, m, hi);
        return inv;
    }

    private static <T extends Comparable<T>> int merge(T[] array, T[] aux, int lo, int m, int hi) {
        System.arraycopy(array, lo, aux, lo, hi - lo + 1);
        int inv = 0;
        int i = lo;
        int j = m + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > m) array[k] = aux[j++];
            else if (j > hi) array[k] = aux[i++];
            else if (less(aux[i], aux[j])) array[k] = aux[i++];
            else {
                array[k] = aux[j++];
                inv += (m - i + 1);
            }
        }
        return inv;
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> T[] newArray(int size) {
        return (T[]) new Comparable[size];
    }
}
