package edu.coursera.algs41;

public interface PriorityQueue<T extends Comparable<T>> extends Queue<T> {
    T sample();
}
