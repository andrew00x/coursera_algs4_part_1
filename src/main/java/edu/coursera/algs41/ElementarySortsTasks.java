package edu.coursera.algs41;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ElementarySortsTasks {
    public static int countIntersection(Point2D[] a, Point2D[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i, j, count;
        i = j = count = 0;
        while (i < a.length && j < b.length) {
            int c = a[i].compareTo(b[j]);
            if (c == 0) {
                i++;
                j++;
                count++;
            } else if (c < 0) i++;
            else j++;
        }
        return count;
    }

    public static boolean isPermuted(int[] a, int[] b) {
        if (a.length != b.length) return false;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }


    enum Pebble {
        RED("r"), WHITE("w"), BLUE("b");

        private final String v;

        Pebble(String v) {
            this.v = v;
        }

        public String toString() {
            return v;
        }
    }

    public static void dutchNationalFlag(Pebble[] pebbles) {
        int l, h, i;
        i = l = 0;
        h = pebbles.length - 1;
        while (i <= h) {
            Pebble p = pebbles[i];
            if (p == Pebble.RED) {
                swap(pebbles, i++, l++);
            } else if (p == Pebble.BLUE) {
                swap(pebbles, i, h--);
            } else {
                i++;
            }
        }
    }

    private static void swap(Pebble[] a, int i, int j) {
        Pebble t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Pebble[] a = new Pebble[]{Pebble.BLUE, Pebble.WHITE, Pebble.BLUE, Pebble.RED, Pebble.WHITE, Pebble.RED, Pebble.RED, Pebble.BLUE, Pebble.WHITE, Pebble.WHITE};
        dutchNationalFlag(a);
        StdOut.println(Arrays.toString(a));
    }
}
