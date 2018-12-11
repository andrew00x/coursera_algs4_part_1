package edu.coursera.algs41;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stack<T> {
    private VNode<T> first;
    private int n;

    public LinkedStack(T[] arr) {
        for (T e : arr) push(e);
    }

    public LinkedStack(Iterable<T> iter) {
        for (T e : iter) push(e);
    }

    public LinkedStack() {
    }

    @Override
    public void push(T o) {
        VNode<T> newFirst = new VNode<>();
        newFirst.value = o;
        newFirst.next = first;
        first = newFirst;
        n++;
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        T o = first.value;
        first = first.next;
        n--;
        return o;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            VNode<T> cur = first;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T o = cur.value;
                cur = cur.next;
                return o;
            }
        };
    }
}
