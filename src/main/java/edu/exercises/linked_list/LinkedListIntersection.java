package edu.exercises.linked_list;

public class LinkedListIntersection {
    public ListNode<Integer> getIntersection(ListNode<Integer> headA, ListNode<Integer> headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode<Integer> a = headA;
        ListNode<Integer> b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }
}
