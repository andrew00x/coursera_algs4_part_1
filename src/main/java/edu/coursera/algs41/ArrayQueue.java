package edu.coursera.algs41;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {
    private T[] array;
    private int head;
    private int tail;

    public ArrayQueue(T[] arr) {
        array = newArray(arr.length);
        for (T e : arr) enqueue(e);
    }

    public ArrayQueue(Iterable<T> iter) {
        this();
        for (T e : iter) enqueue(e);
    }

    public ArrayQueue() {
        array = newArray(1);
    }

    @Override
    public void enqueue(T e) {
        if (tail == array.length) resize(array.length * 2);
        array[tail++] = e;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;
        T o = array[head];
        array[head] = null;
        head++;
        int size = size();
        if (size > 0 && size == array.length / 4) resize(array.length / 2);
        return o;
    }

    @Override
    public boolean isEmpty() {
        return tail == head;
    }

    @Override
    public int size() {
        return tail - head;
    }

    private void resize(int capacity) {
        T[] newArray = newArray(capacity);
        int size = size();
        System.arraycopy(array, head, newArray, 0, size);
        array = newArray;
        head = 0;
        tail = size;
    }

    private T[] newArray(int capacity) {
        return (T[]) new Object[capacity];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = head;

            @Override
            public boolean hasNext() {
                return i < size();
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return array[i++];
            }
        };
    }
}
