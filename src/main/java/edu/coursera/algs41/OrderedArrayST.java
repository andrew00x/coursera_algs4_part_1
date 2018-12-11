package edu.coursera.algs41;

import edu.princeton.cs.algs4.Queue;

public class OrderedArrayST<K extends Comparable, V> implements ST<K, V> {
    private static class Entry {
        Comparable key;
        Object value;

        Entry(Comparable key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] array = new Entry[1];
    private int n;

    @Override
    public void put(K key, V value) {
        if (key == null || value == null) throw new IllegalArgumentException();
        if (isEmpty()) {
            array[n++] = new Entry(key, value);
        } else {
            int i = rank(key);
            if (i < n && array[i].key.equals(key)) {
                array[i].value = value;
            } else {
                if (n == array.length) resize(array.length * 2);
                System.arraycopy(array, i, array, i + 1, n - i);
                array[i] = new Entry(key, value);
                n++;
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) {
        if (key == null) throw new IllegalArgumentException();
        int i = rank(key);
        if (i < n && array[i].key.equals(key)) return (V) array[i].value;
        return null;
    }

    @Override
    public boolean contains(K key) {
        if (key == null) return false;
        int i = rank(key);
        return i < n && array[i].key.equals(key);
    }

    @Override
    public void delete(K key) {
        if (key == null) throw new IllegalArgumentException();
        if (isEmpty()) return;
        int i = rank(key);
        if (i < n && array[i].key.equals(key)) {
            System.arraycopy(array, i + 1, array, i, n - i - 1);
            array[--n] = null;
            if (n > 0 && n == array.length / 4) resize(array.length / 2);
        }
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<K> keys() {
        Queue<K> keys = new Queue<>();
        for (int i = 0; i < n; i++) keys.enqueue((K) array[i].key);
        return keys;
    }

    @Override
    public int size() {
        return n;
    }

    private void resize(int capacity) {
        Entry[] tmp = new Entry[capacity];
        System.arraycopy(array, 0, tmp, 0, array.length);
        array = tmp;
    }

    @SuppressWarnings("unchecked")
    private int rank(K key) {
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            int c = array[m].key.compareTo(key);
            if (c < 0) lo = m + 1;
            else if (c > 0) hi = m - 1;
            else return m;
        }
        return lo;
    }
}
