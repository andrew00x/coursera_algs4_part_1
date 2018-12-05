package edu.coursera.algs41;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.lang.reflect.Method;

import static edu.coursera.algs41.Util.isSorted;

public class SortCompare {
    public static void compare(String alg1, String alg2, int n, int trials) throws Exception {
        double time1 = 0.0;
        time1 = time(alg1, n, trials, time1);
        double time2 = 0.0;
        time2 = time(alg2, n, trials, time2);
        double ratio = time2 / time1;
        StdOut.printf("For %d doubles algorithm %s is %.1f faster than %s\n", n, alg1, ratio, alg2);
    }

    private static double time(String alg, int n, int trials, double time1) throws Exception {
        for (int i = 0; i < trials; i++) {
            Double[] arr = new Double[n];
            for (int j = 0; j < n; j++) arr[j] = StdRandom.uniform(0.0, 1.0);
            time1 += time(alg, arr);
        }
        return time1;
    }

    private static double time(String alg, Comparable[] arr) throws Exception {
        Method sort = Sorts.class.getMethod(alg.endsWith("Sort") ? alg : (alg + "Sort"), Comparable[].class);
        Stopwatch timer = new Stopwatch();
        sort.invoke(null, (Object) arr);
        double time = timer.elapsedTime();
        assert isSorted(arr);
        return time;
    }

    public static void main(String[] args) throws Exception {
        String alg1 = args[0];
        String alg2 = args[1];
        int n = Integer.parseInt(args[2]);
        int trials = Integer.parseInt(args[3]);
        compare(alg1, alg2, n, trials);
    }
}
