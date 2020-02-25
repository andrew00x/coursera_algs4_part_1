package edu.exercises.tree

class TreeNodeHelper {
    static <T> TreeNode<T> createTree(T... data) {
        assert data != null && data.length > 0
        TreeNode root = insertNode(data, 0)
        return root
    }

    private static <T> TreeNode<T> insertNode(T[] data, int i) {
        if (i < data.length) {
            T v = data[i]
            if (v == null) return null
            TreeNode<T> n = new TreeNode<>(v)
            n.left = insertNode(data, i * 2 + 1)
            n.right = insertNode(data, i * 2 + 2)
            return n
        }
        return null
    }
}
