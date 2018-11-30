package edu.coursera.algs41;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<T> implements Deque<T> {
    private T[] array;
    private int head;
    private int tail;

    public ArrayDeque(T[] arr) {
        this();
        for (T e : arr) enqueue(e);
    }

    public ArrayDeque(Iterable<T> iter) {
        this();
        for (T e : iter) enqueue(e);
    }

    public ArrayDeque() {
        array = newArray(4);
    }

    @Override
    public void addFirst(T e) {
        int i = (head - 1) & (array.length - 1);
        array[i] = e;
        head = i;
        if (head == tail) doubleCapacity();
    }

    @Override
    public void addLast(T e) {
        enqueue(e);
    }

    @Override
    public T removeFirst() {
        return dequeue();
    }

    @Override
    public T removeLast() {
        if (isEmpty()) return null;
        int i = (tail - 1) & (array.length - 1);
        T e = array[i];
        array[i] = null;
        tail = i;
        return e;
    }

    @Override
    public void enqueue(T e) {
        array[tail] = e;
        tail = (tail + 1) & (array.length - 1);
        if (tail == head) doubleCapacity();
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;
        T e = array[head];
        array[head] = null;
        head = (head + 1) & (array.length - 1);
        return e;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public int size() {
        return (tail - head) & (array.length - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i = head;

            @Override
            public boolean hasNext() {
                return i != tail;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T e = array[i];
                i = (i + 1) & (array.length - 1);
                return e;
            }
        };
    }

    @SuppressWarnings("unchecked")
    private T[] newArray(int capacity) {
        return (T[]) new Object[capacity];
    }

    private void doubleCapacity() {
        int capacity = array.length * 2;
        T[] newArray = newArray(capacity);
        int r = array.length - head;
        System.arraycopy(array, head, newArray, 0, r);
        System.arraycopy(array, 0, newArray, r, head);
        head = 0;
        tail = array.length;
        array = newArray;
    }
}
