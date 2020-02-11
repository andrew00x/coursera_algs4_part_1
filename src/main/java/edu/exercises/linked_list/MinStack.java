package edu.exercises.linked_list;

public class MinStack {
    private static class MinStackNode extends ListNode<Integer> {
        private final int min;
        private MinStackNode(Integer value, int min) {
            super(value);
            this.min = min;
        }
    }

    private MinStackNode head;

    public void push(int x) {
        MinStackNode newHead = new MinStackNode(x, head == null ? x : Math.min(x, head.min));
        newHead.next = head;
        head = newHead;
    }

    public void pop() {
        head = (MinStackNode) head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min;
    }
}
