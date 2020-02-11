package edu.exercises.linked_list;

import java.util.Objects;

public class ListNode<T> {
    public T value;
    public ListNode<T> next;

    public ListNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("[");
        ListNode<T> cur = this;
        while (cur != null) {
            if (b.length() > 1) b.append(", ");
            b.append(cur.value);
            cur = cur.next;
        }
        b.append(']');
        return b.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ListNode)) return false;
        ListNode<?> other = (ListNode<?>) o;
        return Objects.equals(value, other.value) &&
                Objects.equals(next, other.next);
    }

    @Override
    public int hashCode() {
        throw new AssertionError();
    }
}
