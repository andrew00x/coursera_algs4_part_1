package edu.exercises.linked_list;

public class Middle {
    public <T> ListNode<T> middle(ListNode<T> head) {
        if (head == null) return null;
        ListNode<T> slow = head;
        ListNode<T> fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }
}
