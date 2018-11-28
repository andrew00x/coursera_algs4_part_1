package edu.coursera.algs41;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomQueue<T> implements Queue<T> {
    private T[] array;
    private int n;

    public RandomQueue(T[] array) {
        this.array = newArray(array.length);
        for (T e : array) enqueue(e);
    }

    public RandomQueue(Iterable<T> iter) {
        this();
        for (T e : iter) enqueue(e);
    }

    public RandomQueue() {
        this.array = newArray(1);
    }

    @Override
    public void enqueue(T e) {
        if (n == array.length) resize(array.length * 2);
        array[n++] = e;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;
        int i = StdRandom.uniform(n);
        T e = array[i];
        array[i] = array[--n];
        array[n] = null;
        if (n > 0 && n == array.length / 4) resize(array.length / 2);
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
        int[] idx = new int[n];
        for (int i = 0; i < idx.length; i++) idx[i] = i;
        StdRandom.shuffle(idx);

        return new Iterator<T>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i != idx.length;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return array[idx[i++]];
            }
        };
    }

    @SuppressWarnings("unchecked")
    private T[] newArray(int capacity) {
        return (T[]) new Object[capacity];
    }

    private void resize(int capacity) {
        T[] newArray = newArray(capacity);
        System.arraycopy(array, 0, newArray, 0, n);
        array = newArray;
    }
}
