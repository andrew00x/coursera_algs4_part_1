package edu.coursera.algs41;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

import static edu.coursera.algs41.Util.less;
import static edu.coursera.algs41.Util.median;
import static edu.coursera.algs41.Util.swap;

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
        if (less(array[m], array[m + 1])) return; // improvement for partially ordered arrays
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

    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        Stopwatch timer = new Stopwatch();
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) swap(array, j, j - 1);
        }
        StdOut.printf("insertion sort %d items in %.3f sec\n", array.length, timer.elapsedTime());
    }

    public static <T extends Comparable<T>> void selectionSort(T[] array) {
        Stopwatch timer = new Stopwatch();
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (less(array[j], array[min])) min = j;
            }
            swap(array, min, i);
        }
        StdOut.printf("selection sort %d items in %.3f sec\n", array.length, timer.elapsedTime());
    }

    public static <T extends Comparable<T>> void selectionStableSort(T[] array) {
        Stopwatch timer = new Stopwatch();
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (less(array[j], array[min])) min = j;
            }
            T minVal = array[min];
            System.arraycopy(array, i, array, i + 1, min - i);
            array[i] = minVal;
        }
        StdOut.printf("stable selection sort %d items in %.3f sec\n", array.length, timer.elapsedTime());
    }

    public static <T extends Comparable<T>> void shellSort(T[] array) {
        Stopwatch timer = new Stopwatch();
        int length = array.length;
        int h = 1;
        while (h < length / 3) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) swap(array, j, j - h);
            }
            h = h / 3;
        }
        StdOut.printf("shell sort %d items in %.3f sec\n", array.length, timer.elapsedTime());
    }

    public static <T extends Comparable<T>> void mergeBottomUpSort(T[] array) {
        Stopwatch timer = new Stopwatch();
        int n = array.length;
        T[] aux = newArray(n);
        for (int size = 1; size < n; size *= 2)
            for (int lo = 0; lo < n - size; lo += 2 * size)
                merge(array, aux, lo, lo + size - 1, Math.min(lo + 2 * size - 1, n - 1));
        StdOut.printf("bottom-up merge sort %d items in %.3f sec\n", array.length, timer.elapsedTime());
    }

    public static <T extends Comparable<T>> void quickSort(T[] array) {
        Stopwatch timer = new Stopwatch();
        quickSort(array, 0, array.length - 1);
        StdOut.printf("quick sort %d items in %.3f sec\n", array.length, timer.elapsedTime());
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int lo, int hi) {
        if (lo >= hi) return;
        int i = partition(array, lo, hi);
        quickSort(array, lo, i - 1);
        quickSort(array, i + 1, hi);
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

    public static <T extends Comparable<T>> void quick3waySort(T[] array) {
        Stopwatch timer = new Stopwatch();
        quick3waySort(array, 0, array.length - 1);
        StdOut.printf("3 way quick sort %d items in %.3f sec\n", array.length, timer.elapsedTime());
    }

    private static <T extends Comparable<T>> void quick3waySort(T[] array, int lo, int hi) {
        if (lo >= hi) return;
        T v = array[lo];
        int lt = lo;
        int gt = hi;
        int i = lo;
        while (i <= gt) {
            int c = array[i].compareTo(v);
            if (c < 0) swap(array, i++, lt++);
            else if (c > 0) swap(array, i, gt--);
            else i++;
        }
        quick3waySort(array, lo, lt - 1);
        quick3waySort(array, gt + 1, hi);
    }

    public static <T extends Comparable<T>> void systemSort(T[] array) {
        Stopwatch timer = new Stopwatch();
        Arrays.sort(array);
        StdOut.printf("java system sort %d items in %.3f sec\n", array.length, timer.elapsedTime());
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> T[] newArray(int size) {
        return (T[]) new Comparable[size];
    }
}
