package edu.coursera.algs41;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class IntArrayGen {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        int[] data = new int[num];
        for (int i = 0; i < num; i++) {
            data[i] = i;
            if (StdRandom.bernoulli()) data[i] *= -1;
        }
        StdRandom.shuffle(data);
        for (int i = 0; i < num; i++) StdOut.println(data[i]);
    }
}
