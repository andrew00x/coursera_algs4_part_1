package edu.coursera.algs41;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CircularShiftStrings {

    public boolean checkRotation(String s1, String s2) {
        return s1.length() == s2.length() && ((s1.equals(s2) || (s1 + s1).contains(s2)));
    }

    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        String[] strings = in.readAllStrings();
        CircularShiftStrings shiftStrings = new CircularShiftStrings();
        for (int i = 0; i < strings.length - 1; i += 2) {
            String one = strings[i];
            String two = strings[i + 1];
            StdOut.printf("%s - %s => circular shift match: %s\n", one, two, shiftStrings.checkRotation(one, two));
        }
    }
}
