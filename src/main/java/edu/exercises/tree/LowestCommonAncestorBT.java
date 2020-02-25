package edu.exercises.tree;

import java.util.*;

import static com.google.common.base.Preconditions.checkNotNull;

public class LowestCommonAncestorBT {
    public int findLCA_Rec(TreeNode<Integer> root, int p, int q) {
        checkNotNull(root);
        return _findLCA(root, p, q).value;
    }

    private TreeNode<Integer> _findLCA(TreeNode<Integer> root, int p, int q) {
        if (root == null) return null;
        if (root.value == p || root.value == q) return root;
        TreeNode<Integer> left = _findLCA(root.left, p, q);
        TreeNode<Integer> right = _findLCA(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }



    public int findLCA_Iter(TreeNode<Integer> root, int p, int q) {
        checkNotNull(root);
        Map<Integer, Integer> parents = new HashMap<>();
        Deque<TreeNode<Integer>> stack = new LinkedList<>();
        stack.push(root);
        parents.put(root.value, null);
        TreeNode<Integer> node;
        while (!(parents.containsKey(p) && parents.containsKey(q))) {
            node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
                parents.put(node.right.value, node.value);
            }
            if (node.left != null) {
                stack.push(node.left);
                parents.put(node.left.value, node.value);
            }
        }
        Set<Integer> ancestors = new HashSet<>();
        Integer x = p;
        while (x != null) {
            ancestors.add(x);
            x = parents.get(x);
        }
        x = q;
        while (!ancestors.contains(x)) {
            x = parents.get(x);
        }
        return x;
    }
}
