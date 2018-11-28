package edu.coursera.algs41;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T> {
    private T[] array;
    private int n;

    public ArrayStack(T[] arr) {
        array = newArray(arr.length);
        for (T e : arr) push(e);
    }

    public ArrayStack(Iterable<T> iter) {
        this();
        for (T e : iter) push(e);
    }

    public ArrayStack() {
        array = newArray(1);
    }

    @Override
    public void push(T o) {
        if (n == array.length) resize(array.length * 2);
        array[n++] = o;
    }

    @Override
    public T pop() {
        if (n == 0) return null;
        T o = array[--n];
        array[n] = null;
        if (n > 0 && n == array.length / 4) resize(array.length / 2);
        return o;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    private void resize(int capacity) {
        T[] newArray = newArray(capacity);
        System.arraycopy(array, 0, newArray, 0, n);
        array = newArray;
    }

    @SuppressWarnings("unchecked")
    private T[] newArray(int capacity) {
        return (T[]) new Object[capacity];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = n;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return array[--i];
            }
        };
    }
}
