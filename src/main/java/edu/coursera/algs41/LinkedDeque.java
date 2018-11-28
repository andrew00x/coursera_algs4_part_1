package edu.coursera.algs41;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDeque<T> implements Deque<T> {
    private Node<T> head;
    private Node<T> tail;
    private int n;

    public LinkedDeque(T[] arr) {
        for (T e : arr) enqueue(e);
    }

    public LinkedDeque(Iterable<T> iter) {
        for (T e : iter) enqueue(e);
    }

    public LinkedDeque() {
    }

    @Override
    public void addFirst(T e) {
        Node<T> oldHead = head;
        head = new Node<>();
        head.value = e;
        head.next = null;
        if (tail == null) tail = head;
        else oldHead.prev = head;
        n++;
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
        T e = tail.value;
        tail = tail.prev;
        if (tail == null) head = null;
        else tail.next = null;
        n--;
        return e;
    }

    @Override
    public void enqueue(T e) {
        Node<T> oldTail = tail;
        tail = new Node<>();
        tail.value = e;
        tail.prev = oldTail;
        if (head == null) head = tail;
        else oldTail.next = tail;
        n++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;
        T e = head.value;
        head = head.next;
        if (head == null) tail = null;
        else head.prev = null;
        n--;
        return e;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> cur = head;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T e = cur.value;
                cur = cur.next;
                return e;
            }
        };
    }
}
