package edu.coursera.algs41;

public interface Queue<T> extends Iterable<T> {
    void enqueue(T e);

    T dequeue();

    boolean isEmpty();

    int size();
}
