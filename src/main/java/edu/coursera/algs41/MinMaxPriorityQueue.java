package edu.coursera.algs41;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static edu.coursera.algs41.Util.swap;

public class MinMaxPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    private final boolean min;
    private T[] array;
    private int n;

    public MinMaxPriorityQueue(boolean min) {
        this.min = min;
        array = newArray(2);
    }

    public MinMaxPriorityQueue() {
        this(false);
    }

    private MinMaxPriorityQueue(boolean min, T[] heap) {
        this.min = min;
        array = heap;
        n = array.length - 1;
        assert isHeap(1);
    }

    @Override
    public T sample() {
        return array[1];
    }

    @Override
    public void enqueue(T e) {
        if (n == array.length - 1) resize(array.length * 2);
        array[++n] = e;
        swim(n);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;
        T e = array[1];
        swap(array, 1, n);
        array[n--] = null;
        sink(1);
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
        return new Iter();
    }

    private void resize(int capacity) {
        T[] newArray = newArray(capacity);
        System.arraycopy(array, 1, newArray, 1, n);
        array = newArray;
    }

    private void sink(int i) {
        while (2 * i <= n) {
            int j = i * 2;
            if (j < n && less(j, j + 1)) j++;
            if (less(j, i)) break;
            swap(array, i, j);
            i = j;
        }
    }

    private void swim(int i) {
        while (i > 1 && less(i / 2, i)) {
            swap(array, i, i / 2);
            i = i / 2;
        }
    }

    private boolean less(int i, int j) {
        if (min) return Util.less(array[j], array[i]);
        else return Util.less(array[i], array[j]);
    }

    @SuppressWarnings("unchecked")
    private T[] newArray(int capacity) {
        return (T[]) new Comparable[capacity];
    }

    private boolean isHeap(int i) {
        if (i > n) return true;
        int left = i * 2;
        int right = left + 1;
        if (left <= n && less(i, left)) return false;
        if (right <= n && less(i, right)) return false;
        return isHeap(left) && isHeap(right);
    }

    private class Iter implements Iterator<T> {
        private final MinMaxPriorityQueue<T> copy;

        private Iter() {
            T[] a = newArray(n + 1);
            System.arraycopy(array, 1, a, 1, n);
            copy = new MinMaxPriorityQueue<>(min, a);
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
}
