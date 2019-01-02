package edu.coursera.algs41;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static edu.coursera.algs41.Util.less;

public class MedianQueue implements Queue<Integer> {
    private final PriorityQueue<Integer> max;
    private final PriorityQueue<Integer> min;

    public MedianQueue() {
        max = new MinMaxPriorityQueue<>();
        min = new MinMaxPriorityQueue<>(true);
    }

    public MedianQueue(int[] arr) {
        this();
        for (int e : arr) enqueue(e);
    }

    @Override
    public void enqueue(Integer e) {
        Integer x = max.sample();
        if (x == null || less(e, x)) max.enqueue(e);
        else min.enqueue(e);
        if ((max.size() - min.size()) > 1) min.enqueue(max.dequeue());
        else if ((min.size() - max.size()) > 1) max.enqueue(min.dequeue());
    }

    @Override
    public Integer dequeue() {
        if (isEmpty()) return null;
        if (max.size() > min.size()) return max.dequeue();
        else if (min.size() > max.size()) return min.dequeue();
        else return max.dequeue();
    }

    public double median() {
        if (isEmpty()) throw new IllegalStateException("empty");
        if (max.size() > min.size()) return max.sample();
        else if (min.size() > max.size()) return min.sample();
        else return ((double) max.sample() + min.sample()) / 2;
    }

    @Override
    public boolean isEmpty() {
        return min.isEmpty() && max.isEmpty();
    }

    @Override
    public int size() {
        return min.size() + max.size();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Iterator<Integer> maxI = max.iterator();
            Iterator<Integer> minI = min.iterator();

            @Override
            public boolean hasNext() {
                return maxI.hasNext() || minI.hasNext();
            }

            @Override
            public Integer next() {
                if (maxI.hasNext()) return maxI.next();
                else if (minI.hasNext()) return minI.next();
                else throw new NoSuchElementException();
            }
        };
    }
}
