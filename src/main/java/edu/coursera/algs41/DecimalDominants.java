package edu.coursera.algs41;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.swap;

public class DecimalDominants {
    public void findDecimalDominants(int[] a) {
        findDecimalDominants(a, 0, a.length - 1);
    }

    private void findDecimalDominants(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int i = lo, lt = lo, gt = hi;
        int v = a[lo];
        while (i <= gt) {
            if (a[i] < v) swap(a, i++, lt++);
            else if (a[i] > v) swap(a, i, gt--);
            else i++;
        }
        boolean m = gt - lt + 1 > a.length / 2;
        if (gt - lt + 1 > a.length / 10) System.out.println(v);
        findDecimalDominants(a, lo, lt - 1);
        findDecimalDominants(a, gt + 1, hi);
    }
}
