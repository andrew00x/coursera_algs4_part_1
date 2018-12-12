package edu.coursera.algs41;

import edu.princeton.cs.algs4.Queue;

public class LinearProbingHashST<K, V> implements ST<K, V> {
    private static final int INITIAL_CAPACITY = 4;

    private Entry<K, V>[] array;
    private int n;

    public LinearProbingHashST() {
        this(INITIAL_CAPACITY);
    }

    public LinearProbingHashST(int capacity) {
        array = newArray(Math.max(INITIAL_CAPACITY, capacity));
    }

    @Override
    public void put(K key, V value) {
        if (key == null || value == null) throw new IllegalArgumentException();
        if (n * 2 > array.length) resize(array.length * 2);
        int i;
        for (i = hash(key) % array.length; array[i] != null; i = (i + 1) % array.length) {
            if (array[i].key.equals(key)) {
                array[i].value = value;
                return;
            }
        }
        array[i] = new Entry<>(key, value);
        n++;
    }

    @Override
    public V get(K key) {
        if (key == null) throw new IllegalArgumentException();
        for (int i = hash(key) % array.length; array[i] != null; i = (i + 1) % array.length) {
            if (array[i].key.equals(key)) return array[i].value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return key != null && get(key) != null;
    }

    @Override
    public void delete(K key) {
        if (key == null) throw new IllegalArgumentException();
        int i;
        boolean removed = false;
        for (i = hash(key) % array.length; array[i] != null && !removed; i = (i + 1) % array.length) {
            if (array[i].key.equals(key)) {
                array[i] = null;
                removed = true;
            }
        }

        if (!removed) return;

        n--;

        if (n > INITIAL_CAPACITY && n * 4 < array.length) {
            resize(array.length / 2);
            return;
        }

        for (i = (i + 1) % array.length; array[i] != null; i = (i + 1) % array.length) {
            Entry<K, V> e = array[i];
            array[i] = null;
            n--;
            put(e.key, e.value);
        }
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Iterable<K> keys() {
        Queue<K> keys = new Queue<>();
        for (Entry<K, V> anArray : array) {
            if (anArray != null) keys.enqueue(anArray.key);
        }
        return keys;
    }

    @Override
    public int size() {
        return n;
    }

    private int hash(K key) {
        return key.hashCode() & Integer.MAX_VALUE;
    }

    private void resize(int capacity) {
        LinearProbingHashST<K, V> copy = new LinearProbingHashST<>(capacity);
        for (Entry<K, V> e : array) {
            if (e != null) copy.put(e.key, e.value);
        }
        array = copy.array;
    }

    @SuppressWarnings("unchecked")
    private Entry<K, V>[] newArray(int capacity) {
        return new Entry[capacity];
    }
}
