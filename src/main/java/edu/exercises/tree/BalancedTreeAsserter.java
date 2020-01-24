package edu.exercises.tree;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class BalancedTreeAsserter {
    public static class Node {
        public final Node   left;
        public final Node   right;
        public final Object value;

        public Node(Node left, Node right, Object value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    public static boolean $(Node root) {
        return maxDepth(root) - minDepth(root) <= 1;
    }

    private static int maxDepth(Node node) {
        if (node != null) {
            return max(maxDepth(node.left), maxDepth(node.right)) + 1;
        }
        return 0;
    }

    private static int minDepth(Node node) {
        if (node != null) {
            return min(minDepth(node.left), minDepth(node.right)) + 1;
        }
        return 0;
    }
}
