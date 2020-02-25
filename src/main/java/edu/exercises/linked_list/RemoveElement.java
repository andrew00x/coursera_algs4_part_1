package edu.exercises.linked_list;

import java.util.Objects;

public class RemoveElement {
    public <T> ListNode<T> remove(ListNode<T> head, T value) {
        ListNode<T> newHead = new ListNode<>(null);
        newHead.next = head;
        ListNode<T> cur = newHead;
        while (cur.next != null) {
            if (Objects.equals(cur.next.value, value)) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return newHead.next;
    }
}
