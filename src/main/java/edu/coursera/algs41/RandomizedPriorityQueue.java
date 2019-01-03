package edu.coursera.algs41;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static edu.coursera.algs41.Util.swap;

public class RandomizedPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    private T[] array;
    private int n;

    public RandomizedPriorityQueue(Iterable<T> iter) {
        this();
        for (T e : iter) enqueue(e);
    }

    public RandomizedPriorityQueue() {
        array = newArray(2);
    }

    private RandomizedPriorityQueue(T[] array) {
        this.array = array;
        n = array.length - 1;
        assert isHeap(1);
    }

    @Override
    public T sample() {
        return array[StdRandom.uniform(1, n + 1)];
    }

    @Override
    public void enqueue(T e) {
        if (n == array.length - 1) resize(array.length * 2);
        array[++n] = e;
        swim(n);
    }

    @Override
    public T dequeue() {
        return remove(1);
    }

    public T delRandom() {
        return remove(StdRandom.uniform(1, n + 1));
    }

    private T remove(int i) {
        if (isEmpty()) return null;
        T e = array[i];
        swap(array, i, n);
        array[n--] = null;
        sink(i);
        if (n > 0 && n == array.length / 4) resize(array.length / 2);
        return e;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        private final RandomizedPriorityQueue<T> copy;

        private Iter() {
            T[] a = newArray(n + 1);
            System.arraycopy(array, 1, a, 1, n);
            copy = new RandomizedPriorityQueue<>(a);
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.dequeue();
        }
    }


    @SuppressWarnings("unchecked")
    private T[] newArray(int capacity) {
        return (T[]) new Comparable[capacity];
    }

    private void resize(int capacity) {
        T[] newArray = newArray(capacity);
        System.arraycopy(array, 1, newArray, 1, n);
        array = newArray;
    }

    private void swim(int i) {
        while (i > 1 && less(i / 2, i)) {
            swap(array, i, i / 2);
            i /= 2;
        }
    }

    private void sink(int i) {
        while (i * 2 <= n) {
            int j = i * 2;
            if (j < n && less(j, j + 1)) j++;
            if (less(j, i)) break;
            swap(array, i, j);
            i = j;
        }
    }

    private boolean less(int i, int j) {
        return Util.less(array[i], array[j]);
    }

    private boolean isHeap(int i) {
        if (i > n) return true;
        int left = i * 2;
        int right = left + 1;
        if (left <= n && less(i, left)) return false;
        if (right <= n && less(i, right)) return false;
        return isHeap(left) && isHeap(right);
    }
}
