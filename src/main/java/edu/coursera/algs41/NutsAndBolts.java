package edu.coursera.algs41;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class NutsAndBolts {
    interface Item {
        int getSize();
    }

    public static class Nut implements Item {
        final int size;

        Nut(int size) {
            this.size = size;
        }

        public String toString() {
            return "N" + size;
        }

        @Override
        public int getSize() {
            return size;
        }

        public boolean equals(Object o) {
            return o instanceof Nut && ((Nut) o).size == size;
        }

        @Override
        public int hashCode() {
            throw new AssertionError();
        }
    }

    public static class Bolt implements Item {
        final int size;

        Bolt(int size) {
            this.size = size;
        }

        public String toString() {
            return "B" + size;
        }

        @Override
        public int getSize() {
            return size;
        }

        public boolean equals(Object o) {
            return o instanceof Bolt && ((Bolt) o).size == size;
        }

        @Override
        public int hashCode() {
            throw new AssertionError();
        }
    }

    public static class Pair {
        final Nut nut;
        final Bolt bolt;

        Pair(Nut nut, Bolt bolt) {
            this.nut = nut;
            this.bolt = bolt;
        }

        void assertMatch() {
            if (nut.getSize() != bolt.getSize())
                throw new AssertionError("Nut " + nut + " does not match to bolt " + bolt);
        }

        public String toString() {
            return bolt + " -> " + nut;
        }

        public boolean equals(Object o) {
            return o instanceof Pair && ((Pair) o).nut.equals(nut) && ((Pair) o).bolt.equals(bolt);
        }

        @Override
        public int hashCode() {
            throw new AssertionError();
        }
    }

    public static Pair[] match(Nut[] nuts, Bolt[] bolts) {
        if (nuts.length != bolts.length) throw new AssertionError();
        match(nuts, bolts, 0, nuts.length - 1);
        Pair[] pairs = new Pair[nuts.length];
        for (int i = 0; i < nuts.length; i++) {
            pairs[i] = new Pair(nuts[i], bolts[i]);
            pairs[i].assertMatch();
        }
        return pairs;
    }

    private static void match(Nut[] nuts, Bolt[] bolts, int lo, int hi) {
        if (lo >= hi) return;
        int i = partition(bolts, lo, hi, nuts[lo].getSize());

        partition(nuts, lo, hi, bolts[i].getSize());
        match(nuts, bolts, lo, i - 1);
        match(nuts, bolts, i + 1, hi);
    }

    private static int partition(Item[] items, int lo, int hi, int size) {
        int i = lo;
        int j = hi;
        while (i < j) {
            while (items[i].getSize() < size) {
                if (i == hi) break;
                i++;
            }
            while (items[j].getSize() > size) {
                if (j == lo) break;
                j--;
            }
            swap(items, i, j);
        }
        return j;
    }

    private static void swap(Item[] items, int i, int j) {
        Item t = items[i];
        items[i] = items[j];
        items[j] = t;
    }

    public static void main(String[] args) {
        Nut[] nuts = new Nut[]{new Nut(1), new Nut(4), new Nut(2), new Nut(3), new Nut(5)};
        Bolt[] bolts = new Bolt[]{new Bolt(3), new Bolt(5), new Bolt(2), new Bolt(1), new Bolt(4)};
        Pair[] pairs = match(nuts, bolts);
        StdOut.println(Arrays.toString(pairs));
    }
}
