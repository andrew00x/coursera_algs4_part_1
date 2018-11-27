package edu.coursera.algs41;

public class BitonicArraySearch {
    private final int[] data;
    private final int bitonic;

    public BitonicArraySearch(int[] data) {
        int bitonic = findBitonicIndex(data, 0, data.length - 1);
        if (bitonic < 0) throw new IllegalArgumentException("array is not bitonic");
        this.bitonic = bitonic;
        this.data = data;
    }

    private int findBitonicIndex(int[] arr, int lo, int hi) {
        if (lo >= hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
        else if (arr[mid] > arr[mid - 1] && arr[mid + 1] > arr[mid]) return findBitonicIndex(arr, mid + 1, hi);
        else return findBitonicIndex(arr, lo, mid - 1);
    }

    public int find(int val) {
        int i = findAscending(data, val, 0, bitonic);
        if (i < 0) i = findDescending(data, val, bitonic + 1, data.length - 1);
        return i;
    }

    private int findAscending(int[] arr, int val, int lo, int hi) {
        if (lo >= hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] < val) return findAscending(arr, val, mid + 1, hi);
        else if (arr[mid] > val) return findAscending(arr, val, lo, mid - 1);
        else return mid;
    }

    private int findDescending(int[] arr, int val, int lo, int hi) {
        if (lo >= hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] < val) return findDescending(arr, val, lo, mid - 1);
        else if (arr[mid] > val) return findDescending(arr, val, mid + 1, hi);
        else return mid;
    }
}
