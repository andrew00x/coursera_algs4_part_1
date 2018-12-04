package edu.coursera.algs41;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

import static edu.coursera.algs41.Util.swap;

public class KnuthShuffle {
    public static void shuffle(Object[] data) {
        int n = data.length - 1;
        while (n > 0) {
            int i = StdRandom.uniform(n--);
            swap(data, i, n);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        shuffle(a);
        StdOut.println(Arrays.toString(a));
    }
}
