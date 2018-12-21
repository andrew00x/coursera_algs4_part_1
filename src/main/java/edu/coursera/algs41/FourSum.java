package edu.coursera.algs41;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import org.javatuples.Pair;
import org.javatuples.Quartet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum {
    public Iterable<Quartet<Integer, Integer, Integer, Integer>> find4Sums(int[] input) {
        Queue<Quartet<Integer, Integer, Integer, Integer>> result = new Queue<>();
//        find4SumsBruteForce(result, input);
        find4SumsHash(result, input);
        return result;
    }

   private void find4SumsBruteForce(Queue<Quartet<Integer, Integer, Integer, Integer>> result, int[] input) {
        for (int i = 0; i < input.length - 3; i++) {
            for (int j = i + 1; j < input.length - 2; j++) {
                for (int k = j + 1; k < input.length - 1; k++) {
                    for (int l = k + 1; l < input.length; l++) {
                        if (input[i] + input[j] == input[k] + input[l]
                                || input[i] + input[k] == input[j] + input[l]
                                || input[i] + input[l] == input[k] + input[j]) {
                            result.enqueue(new Quartet<>(i, j, k, l));
                        }
                    }
                }
            }
        }
    }

    private void find4SumsHash(Queue<Quartet<Integer, Integer, Integer, Integer>> result, int[] a) {
        if (a.length > 3) {
            Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    int sum = a[i] + a[j];
                    List<Pair<Integer, Integer>> l = map.get(sum);
                    if (l == null) map.put(sum, l = new ArrayList<>());
                    l.add(new Pair<>(i, j));
                }
            }
            for (List<Pair<Integer, Integer>> pairs : map.values()) {
                for (int i = 0; i < pairs.size(); i++) {
                    Pair<Integer, Integer> p = pairs.get(i);
                    for (int j = i + 1; j < pairs.size(); j++) {
                        result.enqueue(new Quartet<>(p.getValue0(), p.getValue1(), pairs.get(j).getValue0(), pairs.get(j).getValue1()));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int[] data = in.readAllInts();
        for (Quartet<Integer, Integer, Integer, Integer> sums : new FourSum().find4Sums(data)) {
            StdOut.printf("%d, %d, %d, %d\n", data[sums.getValue0()], data[sums.getValue1()], data[sums.getValue2()], data[sums.getValue3()]);
        }
    }
}

