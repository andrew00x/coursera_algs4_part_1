package edu.exercises.tree;

import java.util.Objects;

public class TreeNode<T> {
    public TreeNode<T> left;
    public TreeNode<T> right;
    public final T value;

    public TreeNode(TreeNode<T> left, TreeNode<T> right, T value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public TreeNode(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TreeNode)) return false;
        TreeNode<?> other = (TreeNode<?>) o;
        return Objects.equals(value, other.value)
                && Objects.equals(right, other.right)
                && Objects.equals(left, other.left);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, value);
    }
}
