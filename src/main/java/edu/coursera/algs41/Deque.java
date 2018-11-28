package edu.coursera.algs41;

public interface Deque<T> extends Queue<T> {
    void addFirst(T e);

    void addLast(T e);

    T removeFirst();

    T removeLast();
}
