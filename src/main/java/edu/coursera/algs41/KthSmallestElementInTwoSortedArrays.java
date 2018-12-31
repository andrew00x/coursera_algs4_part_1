package edu.coursera.algs41;

import static edu.coursera.algs41.Util.isSorted;
import static edu.coursera.algs41.Util.less;

public class KthSmallestElementInTwoSortedArrays {
    public <T extends Comparable<T>> T kthSmallestSlow1(T[] a, T[] b, int k) {
        // complexity O(n + m), n = a.length m = b.length
        validateInput(a, b, k);
        if (a.length == 0) return b[k - 1];
        if (b.length == 0) return a[k - 1];
        if (k == 1) return less(a[0], b[0]) ? a[0] : b[0];
        if (k == (a.length + b.length)) return less(a[a.length - 1], b[b.length - 1]) ? b[b.length - 1] : a[a.length - 1];
        T[] merged = newArray(a.length + b.length);
        int i = 0, j = 0;
        for (int x = 0; x < merged.length; x++) {
            if (i == a.length) merged[x] = b[j++];
            else if (j == b.length) merged[x] = a[i++];
            else if (less(a[i], b[j])) merged[x] = a[i++];
            else merged[x] = b[j++];
        }
        assert isSorted(merged);
        return merged[k - 1];
    }

    public <T extends Comparable<T>> T kthSmallestSlow2(T[] a, T[] b, int k) {
        // complexity O(k)
        validateInput(a, b, k);
        if (a.length == 0) return b[k - 1];
        if (b.length == 0) return a[k - 1];
        if (k == 1) return less(a[0], b[0]) ? a[0] : b[0];
        if (k == (a.length + b.length)) return less(a[a.length - 1], b[b.length - 1]) ? b[b.length - 1] : a[a.length - 1];
        T kth = less(a[0], b[0]) ? a[0] : b[0];
        int i = 0, j = 0;
        while ((i + j + 1) <= k) {
            if (i == a.length) kth = b[j++];
            else if (j == b.length) kth = a[i++];
            else if (less(a[i], b[j])) kth = a[i++];
            else kth = b[j++];
        }
        return kth;
    }

    public <T extends Comparable<T>> T kthSmallestFast(T[] a, T[] b, int k) {
        // complexity O(log k)
        return kthSmallestFast(a, 0, b, 0, k);
    }

    private <T extends Comparable<T>> T kthSmallestFast(T[] a, int alo, T[] b, int blo, int k) {
        if (alo + blo + 1 == k) {
            if (alo >= a.length) return b[blo];
            if (blo >= b.length) return a[alo];
            return less(a[alo], b[blo]) ? a[alo] : b[blo];
        }
        int i = (k + alo - blo) / 2;
        int j = (k + blo - alo) / 2;
        if (i > a.length) return kthSmallestFast(a, alo, b, j, k);
        if (j > b.length) return kthSmallestFast(a, i, b, blo, k);
        if (less(a[i - 1], b[j - 1])) return kthSmallestFast(a, i, b, blo, k);
        return kthSmallestFast(a, alo, b, j, k);
    }

    private <T extends Comparable<T>> void validateInput(T[] a, T[] b, int k) {
        if (!isSorted(a)) throw new AssertionError("First array is not sorted");
        if (!isSorted(b)) throw new AssertionError("Second array is not sorted");
        if (k > (a.length + b.length)) throw new AssertionError("k is too big");
    }

    @SuppressWarnings("unchecked")
    private <T extends Comparable<T>> T[] newArray(int size) {
        return (T[]) new Comparable[size];
    }
}
