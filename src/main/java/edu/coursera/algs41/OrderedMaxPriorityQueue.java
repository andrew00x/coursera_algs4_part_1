package edu.coursera.algs41;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderedMaxPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    private final T[] array;
    private int n;

    @SuppressWarnings("unchecked")
    public OrderedMaxPriorityQueue(int capacity) {
        array = (T[]) new Comparable[capacity];
    }

    @Override
    public T sample() {
        return array[0];
    }

    @Override
    public void enqueue(T e) {
        if (n == array.length) throw new IllegalStateException("queue is full");
        if (isEmpty()) {
            array[0] = e;
        } else {
            int r = rank(e);
            System.arraycopy(array, r, array, r + 1, n - r);
            array[r] = e;
        }
        n++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;
        T e = array[0];
        System.arraycopy(array, 1, array, 0, n);
        array[--n] = null;
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
                return i < n;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return array[i++];
            }
        };
    }

    private int rank(T e) {
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            int c = e.compareTo(array[m]);
            if (c < 0) lo = m + 1;
            else if (c > 0) hi = m - 1;
            else return m;
        }
        return lo;
    }
}
