package edu.coursera.algs41;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

import static edu.coursera.algs41.Util.isSorted;
import static edu.coursera.algs41.Util.less;

public class MergeWithSmallerAuxiliaryArray {
    private static <T extends Comparable<T>> void merge(T[] array, T[] aux, int lo, int m, int hi) {
        int i = lo;
        int j = m;
        System.arraycopy(array, i, aux, i, m);
        for (int k = lo; k <= hi; k++) {
            if (i > m) array[k] = array[j++];
            else if (j > hi) array[k] = aux[i++];
            else if (less(aux[i], array[j])) array[k] = aux[i++];
            else array[k] = array[j++];
        }
    }

    public static void main(String[] args) {
        int n = args.length;
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) array[i] = Integer.parseInt(args[i]);

        StdOut.printf("input:  %s\n", Arrays.toString(array));

        int m = n / 2;

        assert n % 2 == 0;
        assert isSorted(array, 0, m - 1);
        assert isSorted(array, m, n - 1);

        merge(array, new Integer[m], 0, m, n - 1);
        StdOut.printf("output: %s\n", Arrays.toString(array));
    }
}
