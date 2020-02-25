package edu.exercises.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class BalancedTreeAsserterTest {
    @Parameter(0)
    public TreeNode tree;

    @Parameter(1)
    public boolean isBalanced;

    @Parameters
    public static Iterable<Object[]> testData() {
        return newArrayList(new Object[][]{
                {createBalancedTree(), true},
                {createNotBalancedTree(), false}
        });
    }

    private static TreeNode createBalancedTree() {
        TreeNode node1 = new TreeNode(null, null, null);
        TreeNode node2 = new TreeNode(null, null, null);
        TreeNode node3 = new TreeNode(node1, null, null);
        TreeNode node4 = new TreeNode(node2, null, null);
        TreeNode root = new TreeNode(node3, node4, null);
        return root;
    }

    private static TreeNode createNotBalancedTree() {
        TreeNode node1 = new TreeNode(null, null, null);
        TreeNode node2 = new TreeNode(null, null, null);
        TreeNode node3 = new TreeNode(node1, node2, null);
        TreeNode node4 = new TreeNode(node3, null, null);
        TreeNode root = new TreeNode(node4, null, null);
        return root;
    }

    @Test
    public void isTreeBalanced() {
        assertThat(BalancedTreeAsserter.$(tree)).isEqualTo(isBalanced);
    }
}