package edu.exercises.linked_list;

public class Palindrome {
    public <T> boolean isPalindrome(ListNode<T> head) {
        if (head == null) return true;
        ListNode<T> currRight = reverse(middle(head));
        ListNode<T> curr = head;
        while (currRight != null) {
            if (curr.value != currRight.value) return false;
            curr = curr.next;
            currRight = currRight.next;
        }
        return true;
    }

    private <T> ListNode<T> middle(ListNode<T> head) {
        ListNode<T> slow = head;
        ListNode<T> fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }

    private <T> ListNode<T> reverse(ListNode<T> head) {
        ListNode<T> curr = head;
        ListNode<T> prev = null;
        ListNode<T> next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
