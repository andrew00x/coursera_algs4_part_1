package edu.coursera.algs41;

public interface Stack<T> extends Iterable<T> {
    void push(T o);

    T pop();

    boolean isEmpty();

    int size();
}
