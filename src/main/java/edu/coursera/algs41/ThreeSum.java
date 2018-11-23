package edu.coursera.algs41;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import org.javatuples.Triplet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSum {

    public Iterable<Triplet<Integer, Integer, Integer>> find3Sums(int[] input, int val) {
        int length = input.length;
        Queue<Triplet<Integer, Integer, Integer>> sums = new Queue<>();
        if (length < 3) return null;
        int[] copy = new int[length];
        System.arraycopy(input, 0, copy, 0, length);
        Arrays.sort(copy);
        if (hasDuplicates(copy)) throw new IllegalArgumentException("input data contains duplicates");
        Stopwatch timer = new Stopwatch();
        findTwoEndsSearch(copy, sums, val);
//        find3SumsBinarySearch(copy, sums, val);
//        find3SumsHashSet(copy, sums, val);
        StdOut.printf("Time %.3f sec\n", timer.elapsedTime());
        return sums;
    }

    private boolean hasDuplicates(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) return true;
        }
        return false;
    }

    private void findTwoEndsSearch(int[] input, Queue<Triplet<Integer, Integer, Integer>> sums, int val) {
        int i, j, k;
        for (i = 0; i < input.length - 2; i++) {
            j = i + 1;
            k = input.length - 1;
            while (j < k) {
                int sum = input[i] + input[j] + input[k];
                if (sum == val) {
                    sums.enqueue(new Triplet<>(input[i], input[j], input[k]));
                    j++;
                    k--;
                } else if (sum < val) {
                    j++;
                } else {
                    k--;
                }
            }
        }
    }


    private void find3SumsBinarySearch(int[] input, Queue<Triplet<Integer, Integer, Integer>> sums, int val) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                int k = Arrays.binarySearch(input, j + 1, input.length, val - input[i] - input[j]);
                if (k > 0) sums.enqueue(new Triplet<>(input[i], input[j], input[k]));
            }
        }
    }

    private void find3SumsHashSet(int[] input, Queue<Triplet<Integer, Integer, Integer>> sums, int val) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < input.length - 1; i++) {
            set.clear();
            for (int j = i + 1; j < input.length; j++) {
                int x = val - input[i] - input[j];
                if (set.contains(x)) sums.enqueue(new Triplet<>(input[i], input[j], x));
                set.add(input[j]);
            }
        }
    }

    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int[] data = in.readAllInts();
        for (Triplet<Integer, Integer, Integer> sums : new ThreeSum().find3Sums(data, 0)) {
            StdOut.printf("%d, %d, %d\n", sums.getValue0(), sums.getValue1(), sums.getValue2());
        }
    }
}

