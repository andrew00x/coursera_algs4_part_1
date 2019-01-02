package edu.coursera.algs41;

import edu.princeton.cs.algs4.Queue;

import static edu.coursera.algs41.Util.less;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.swap;

public class MajorityElementFinder {
    private final int ratio;

    public MajorityElementFinder(int ratio) {
        if (ratio <= 1) throw new IllegalArgumentException("ratio must be greater than 1");
        this.ratio = ratio;
    }

    public <T extends Comparable<T>> Iterable<T> findMajorityElements(T[] a) {
        Queue<T> result = new Queue<>();
        findMajorityElements(result, a, 0, a.length - 1);
        return result;
    }

    private <T extends Comparable<T>> void findMajorityElements(Queue<T> result, T[] a, int lo, int hi) {
        if (lo >= hi) return;
        int i = lo, lt = lo, gt = hi;
        T v = a[lo];
        while (i <= gt) {
            if (less(a[i], v)) swap(a, i++, lt++);
            else if (less(v, a[i])) swap(a, i, gt--);
            else i++;
        }
        if (gt - lt + 1 > a.length / ratio) result.enqueue(v);
        findMajorityElements(result, a, lo, lt - 1);
        findMajorityElements(result, a, gt + 1, hi);
    }
}
