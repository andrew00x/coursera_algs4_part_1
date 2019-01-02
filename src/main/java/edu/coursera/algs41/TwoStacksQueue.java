package edu.coursera.algs41;

import java.util.Iterator;

public class TwoStacksQueue<T> implements Queue<T> {
    private final Stack<T> in;
    private final Stack<T> out;
    private int size;

    public TwoStacksQueue(T[] arr) {
        this();
        for (T e : arr) enqueue(e);
    }

    public TwoStacksQueue(Iterable<T> iter) {
        this();
        for (T e : iter) enqueue(e);
    }

    public TwoStacksQueue() {
        in = new ArrayStack<>();
        out = new ArrayStack<>();
    }

    @Override
    public void enqueue(T o) {
        in.push(o);
        size++;
    }

    @Override
    public T dequeue() {
        if (out.isEmpty()) moveInToOut();
        T o = out.pop();
        if (o != null) size--;
        return o;
    }

    private void moveInToOut() {
        while (!in.isEmpty()) out.push(in.pop());
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        moveInToOut();
        return out.iterator();
    }
}
