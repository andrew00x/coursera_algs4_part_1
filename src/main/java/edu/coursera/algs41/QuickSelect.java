package edu.coursera.algs41;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import static edu.coursera.algs41.Util.less;
import static edu.coursera.algs41.Util.median;
import static edu.coursera.algs41.Util.swap;

public class QuickSelect {
    public static <T extends Comparable<T>> T select(T[] array, int k) {
        Stopwatch timer = new Stopwatch();
        int lo = 0, hi = array.length - 1;
        T res = null;
        while (lo < hi && res == null) {
            int i = partition(array, lo, hi);
            if (i < k) lo = i + 1;
            else if (i > k) hi = i - 1;
            else res = array[k];
        }
        if (res == null) res = array[k];
        StdOut.printf("quick select from %d items in %.3f sec\n", array.length, timer.elapsedTime());
        return res;
    }

    private static <T extends Comparable<T>> int partition(T[] array, int lo, int hi) {
        int m = median(array, lo, hi, lo + (hi - lo) / 2);
        swap(array, m, lo);
        T v = array[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(array[++i], v)) {
                if (i == hi) break;
            }
            while (less(v, array[--j])) {
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(array, i, j);
        }
        swap(array, lo, j);
        return j;
    }
}
