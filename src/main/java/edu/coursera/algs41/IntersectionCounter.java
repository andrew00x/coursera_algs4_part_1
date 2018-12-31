package edu.coursera.algs41;

import java.util.Arrays;

public class IntersectionCounter {
    public <T extends Comparable<T>> int countIntersection(T[] a, T[] b) {
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
}
