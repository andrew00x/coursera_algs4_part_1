package edu.coursera.algs41;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Taxicab {
    static class CubeSum implements Comparable<CubeSum> {
        final int a;
        final int b;
        final int sum;

        CubeSum(int a, int b) {
            this.a = a;
            this.b = b;
            sum = cube(a) + cube(b);
        }

        private static int cube(int x) {
            return x * x * x;
        }

        @Override
        public int compareTo(CubeSum o) {
            return Integer.compare(sum, o.sum);
        }
    }

    public static class TaxicabNumber {
        public final int a, b, c, d, taxicab;

        private TaxicabNumber(int a, int b, int c, int d, int taxicab) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.taxicab = taxicab;
        }

        @Override
        public String toString() {
            return String.format("T(2) = %d, %d^3 + %d^3 == %d^3 + %d^3", taxicab, a, b, c, d);
        }
    }

    private final int n;

    public Taxicab(int n) {
        this.n = n;
    }

    public Iterable<TaxicabNumber> findNumbers() {
        PriorityQueue<CubeSum> q = new MinMaxPriorityQueue<>(true);
        for (int i = 1; i != n; i++) q.enqueue(new CubeSum(i, i));
        CubeSum last = null;
        Queue<TaxicabNumber> result = new LinkedQueue<>();
        while (!q.isEmpty()) {
            CubeSum min = q.dequeue();
            if (last != null && last.compareTo(min) == 0) {
                result.enqueue(new TaxicabNumber(min.a, min.b, last.a, last.b, min.sum));
            }
            if (min.b < n) q.enqueue(new CubeSum(min.a, min.b + 1));
            last = min;
        }
        return result;
    }

    public static void main(String[] args) {
        Iterator<TaxicabNumber> res = new Taxicab(Integer.parseInt(args[0])).findNumbers().iterator();
        for (int i = 1; res.hasNext(); i++) StdOut.printf("%d. %s\n", i, res.next());
    }
}
