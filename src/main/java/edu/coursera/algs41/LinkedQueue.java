package edu.coursera.algs41;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {
    private Node<T> first;
    private Node<T> last;
    private int n;

    public LinkedQueue(T[] arr) {
        for (T e : arr) enqueue(e);
    }

    public LinkedQueue(Iterable<T> iter) {
        for (T e : iter) enqueue(e);
    }

    public LinkedQueue() {
    }

    @Override
    public void enqueue(T e) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.item = e;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        n++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;
        T o = first.item;
        first = first.next;
        if (isEmpty()) last = null;
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
