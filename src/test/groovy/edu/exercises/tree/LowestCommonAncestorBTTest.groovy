package edu.exercises.tree

import spock.lang.Specification
import spock.lang.Unroll

import static edu.exercises.tree.TreeNodeHelper.createTree

class LowestCommonAncestorBTTest extends Specification {
    @Unroll
    def 'recursively find lowest common ancestor in binary tree'() {
        given:
        def underTest = new LowestCommonAncestorBT()

        expect:
        expected == underTest.findLCA_Rec(root, p, q)

        where:
        root                                              | p | q || expected
        createTree(2, 6, 8)                               | 6 | 8 || 2
        createTree(6, 2, 8)                               | 6 | 2 || 6
        createTree(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5) | 3 | 5 || 4
        createTree(2, 6, 8, 7, 4, 0, 9, null, null, 3, 5) | 4 | 8 || 2
    }

    @Unroll
    def 'iteratively find lowest common ancestor in binary tree'() {
        given:
        def underTest = new LowestCommonAncestorBT()

        expect:
        expected == underTest.findLCA_Iter(root, p, q)

        where:
        root                                              | p | q || expected
        createTree(2, 6, 8)                               | 6 | 8 || 2
        createTree(6, 2, 8)                               | 6 | 2 || 6
        createTree(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5) | 3 | 5 || 4
        createTree(2, 6, 8, 7, 4, 0, 9, null, null, 3, 5) | 4 | 8 || 2
    }
}
