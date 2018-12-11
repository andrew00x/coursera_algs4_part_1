package edu.coursera.algs41;

public interface ST<K, V> {
    void put(K key, V value);

    V get(K key);

    boolean contains(K key);

    void delete(K key);

    boolean isEmpty();

    Iterable<K> keys();

    int size();
}
