package edu.exercises.linked_list

class ListNodeHelper {
    static <T> ListNode<T> createList(T... data) {
        assert data != null && data.length > 0
        ListNode<T> head = new ListNode<>(data[0])
        ListNode cur = head
        for (int i = 1; i < data.length; i++) {
            cur.next = new ListNode<>(data[i])
            cur = cur.next
        }
        return head
    }
}
