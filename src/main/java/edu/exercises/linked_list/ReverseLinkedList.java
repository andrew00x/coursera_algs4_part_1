package edu.exercises.linked_list;

public class ReverseLinkedList {
    public <T> ListNode<T> reverse(ListNode<T> head) {
        ListNode<T> curr = head;
        ListNode<T> prev = null;
        ListNode<T> next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public <T> ListNode<T> copyReverse(ListNode<T> head) {
        ListNode<T> dummy = new ListNode<>(null);
        ListNode<T> curr = head;
        while (curr != null) {
            ListNode<T> n = new ListNode<>(curr.value);
            n.next = dummy.next;
            dummy.next = n;
            curr = curr.next;
        }
        return dummy.next;
    }

    public <T> ListNode<T> reverseRecursive(ListNode<T> head) {
        if (head.next == null) return head;
        ListNode<T> r = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return r;
    }
}
