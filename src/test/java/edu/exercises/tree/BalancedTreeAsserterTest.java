package edu.exercises.tree;

import edu.exercises.tree.BalancedTreeAsserter.Node;

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
    public Node tree;

    @Parameter(1)
    public boolean isBalanced;

    @Parameters
    public static Iterable<Object[]> testData() {
        return newArrayList(new Object[][]{
                {createBalancedTree(), true},
                {createNotBalancedTree(), false}
        });
    }

    private static Node createBalancedTree() {
        Node node1 = new Node(null, null, null);
        Node node2 = new Node(null, null, null);
        Node node3 = new Node(node1, null, null);
        Node node4 = new Node(node2, null, null);
        Node root = new Node(node3, node4, null);
        return root;
    }

    private static Node createNotBalancedTree() {
        Node node1 = new Node(null, null, null);
        Node node2 = new Node(null, null, null);
        Node node3 = new Node(node1, node2, null);
        Node node4 = new Node(node3, null, null);
        Node root = new Node(node4, null, null);
        return root;
    }

    @Test
    public void isTreeBalanced() {
        assertThat(BalancedTreeAsserter.$(tree)).isEqualTo(isBalanced);
    }
}