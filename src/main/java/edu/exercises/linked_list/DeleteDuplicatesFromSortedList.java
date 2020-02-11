package edu.exercises.linked_list;

public class DeleteDuplicatesFromSortedList {
    public static ListNode<Integer> deleteDuplicates(ListNode<Integer> head) {
        ListNode<Integer> cur = head;
        while (cur != null  && cur.next != null) {
            if (cur.value.equals(cur.next.value)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
