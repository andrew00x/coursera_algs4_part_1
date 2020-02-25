package edu.exercises.tree;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class BalancedTreeAsserter {

    public static boolean $(TreeNode root) {
        return maxDepth(root) - minDepth(root) <= 1;
    }

    private static int maxDepth(TreeNode node) {
        if (node != null) {
            return max(maxDepth(node.left), maxDepth(node.right)) + 1;
        }
        return 0;
    }

    private static int minDepth(TreeNode node) {
        if (node != null) {
            return min(minDepth(node.left), minDepth(node.right)) + 1;
        }
        return 0;
    }
}
