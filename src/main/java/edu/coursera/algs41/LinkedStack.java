package edu.coursera.algs41;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stack<T> {
    private Node<T> first;
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
        Node<T> newFirst = new Node<>();
        newFirst.item = o;
        newFirst.next = first;
        first = newFirst;
        n++;
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        T o = first.item;
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
            Node<T> cur = first;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T o = cur.item;
                cur = cur.next;
                return o;
            }
        };
    }
}
