package edu.coursera.algs41;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static edu.coursera.algs41.Util.less;

public class UnorderedMaxPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    private final T[] array;
    private int n;

    @SuppressWarnings("unchecked")
    public UnorderedMaxPriorityQueue(int capacity) {
        this.array = (T[]) new Comparable[capacity];
    }

    @Override
    public T sample() {
        return array[max()];
    }

    @Override
    public void enqueue(T e) {
        if (n == array.length) throw new IllegalStateException("queue is full");
        array[n++] = e;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;
        int m = max();
        T e = array[m];
        array[m] = array[--n];
        array[n] = null;
        return e;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i;

            @Override
            public boolean hasNext() {
                return i != n;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return array[i++];
            }
        };
    }

    private int max() {
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (less(array[m], array[i])) m = i;
        }
        return m;
    }
}
