package edu.coursera.algs41;

import edu.princeton.cs.algs4.Queue;

public class HashST<K, V> implements ST<K, V> {
    private static final int INITIAL_CAPACITY = 4;

    private KVNode<K, V>[] array;
    private int n;

    public HashST() {
        this(INITIAL_CAPACITY);
    }

    public HashST(int capacity) {
        array = newArray(capacity);
    }

    @Override
    public void put(K key, V value) {
        if (key == null || value == null) throw new IllegalArgumentException();
        if (n > 10 * array.length) resize(array.length * 2);
        int i = hash(key) % array.length;
        KVNode<K, V> node = null;
        for (KVNode<K, V> x = array[i]; x != null && node == null; x = x.next) {
            if (x.key.equals(key)) node = x;
        }
        if (node == null) {
            array[i] = new KVNode<>(key, value, array[i]);
            n++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) throw new IllegalArgumentException();
        int i = hash(key) % array.length;
        for (KVNode<K, V> x = array[i]; x != null; x = x.next) {
            if (x.key.equals(key)) return x.value;
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
        int i = hash(key) % array.length;
        array[i] = delete(array[i], key);
        if (n > INITIAL_CAPACITY && n < 2 * array.length) resize(array.length / 2);
    }

    private KVNode<K, V> delete(KVNode<K, V> node, K key) {
        if (node == null) return null;
        if (node.key.equals(key)) {
            n--;
            return node.next;
        }
        node.next = delete(node.next, key);
        return node;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Iterable<K> keys() {
        Queue<K> keys = new Queue<>();
        for (KVNode<K, V> anArray : array) {
            for (KVNode<K, V> x = anArray; x != null; x = x.next) keys.enqueue(x.key);
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

    @SuppressWarnings("unchecked")
    private KVNode<K, V>[] newArray(int size) {
        return new KVNode[size];
    }

    private void resize(int capacity) {
        KVNode<K, V>[] tmp = newArray(capacity);
        for (KVNode<K, V> anArray : array) {
            for (KVNode<K, V> x = anArray; x != null; x = x.next) {
                K key = x.key;
                int j = hash(key) % tmp.length;
                tmp[j] = new KVNode<>(x.key, x.value, tmp[j]);
            }
        }
        array = tmp;
    }
}
