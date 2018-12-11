package edu.coursera.algs41;

import edu.princeton.cs.algs4.Queue;

public class LinkedListST<K, V> implements ST<K, V> {
    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node<K, V> head;
    private int n;

    @Override
    public void put(K key, V value) {
        if (key == null || value == null) throw new IllegalArgumentException();
        Node<K, V> node = getNode(key);
        if (node == null) {
            head = new Node<>(key, value, head);
            n++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) throw new IllegalArgumentException();
        Node<K, V> node = getNode(key);
        if (node != null) return node.value;
        return null;
    }

    private Node<K, V> getNode(K key) {
        Node<K, V> cur = head;
        while (cur != null) {
            if (cur.key.equals(key)) return cur;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return key != null && get(key) != null;
    }

    @Override
    public void delete(K key) {
        if (key == null) throw new IllegalArgumentException();
        Node<K, V> node = head, prev = null;
        while (node != null && !node.key.equals(key)) {
            prev = node;
            node = node.next;
        }
        if (node != null) {
            if (prev == null) head = node.next;
            else prev.next = node.next;
            n--;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterable<K> keys() {
        Queue<K> keys = new Queue<>();
        if (!isEmpty()) {
            Node<K, V> cur = head;
            while (cur != null) {
                keys.enqueue(cur.key);
                cur = cur.next;
            }
        }
        return keys;
    }

    @Override
    public int size() {
        return n;
    }
}
