package edu.coursera.algs41;

class KVNode<K, V> {
    final K key;
    V value;
    KVNode<K, V> next;

    KVNode(K key, V value, KVNode<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
