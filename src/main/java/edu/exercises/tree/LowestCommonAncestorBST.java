package edu.exercises.tree;

import static com.google.common.base.Preconditions.checkNotNull;

public class LowestCommonAncestorBST {
    public int findLCA_Rec(TreeNode<Integer> root, int p, int q) {
        checkNotNull(root);
        if (p > root.value && q > root.value) return findLCA_Rec(root.right, p, q);
        else if (p < root.value && q < root.value) return findLCA_Rec(root.left, p, q);
        else return root.value;
    }

    public int findLCA_Iter(TreeNode<Integer> root, int p, int q) {
        checkNotNull(root);
        TreeNode<Integer> node = root;
        while (node != null) {
            if (p > node.value && q > node.value) node = node.right;
            else if (p < node.value && q < node.value) node = node.left;
            else return node.value;
        }
        return root.value;
    }
}
