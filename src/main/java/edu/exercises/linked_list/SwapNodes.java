package edu.exercises.linked_list;

import java.util.Objects;

public class SwapNodes {
    public <T> ListNode<T> swap(ListNode<T> head, T valA, T valB) {
        if (Objects.equals(valA, valB)) return head;
        ListNode<T> nodeA = null;
        ListNode<T> nodeB = null;
        ListNode<T> prevA = null;
        ListNode<T> prevB = null;

        ListNode<T> n = head;
        while (n != null && (nodeA == null || nodeB == null)) {
            if (Objects.equals(valA, n.value)) nodeA = n;
            if (Objects.equals(valB, n.value)) nodeB = n;
            if (nodeA == null) prevA = n;
            if (nodeB == null) prevB = n;
            n = n.next;
        }

        if (nodeA == null || nodeB == null) return head;
        if (prevA == null) head = nodeB;
        else prevA.next = nodeB;
        if (prevB == null) head = nodeA;
        else prevB.next = nodeA;
        ListNode<T> tmp = nodeA.next;
        nodeA.next = nodeB.next;
        nodeB.next = tmp;

        return head;
    }
}
