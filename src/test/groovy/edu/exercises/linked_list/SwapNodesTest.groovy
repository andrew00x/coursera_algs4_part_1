package edu.exercises.linked_list

import spock.lang.Specification
import spock.lang.Unroll

import static edu.exercises.linked_list.ListNodeHelper.createList

class SwapNodesTest extends Specification {
    @Unroll
    def 'swap nodes in linked list'() {
        given:
        def underTest = new SwapNodes()

        expect:
        expected == underTest.swap(input, valA, valB)

        where:
        input                           | valA | valB || expected
        createList(1, 2)                | 1    | 2     | createList(2, 1)
        createList(1, 2, 3, 4)          | 1    | 4     | createList(4, 2, 3, 1)
        createList(1, 2, 3, 4, 5, 6, 7) | 3    | 5     | createList(1, 2, 5, 4, 3, 6, 7)
        createList(1, 2, 3, 4, 5, 6, 7) | 1    | 4     | createList(4, 2, 3, 1, 5, 6, 7)
        createList(1, 2, 3, 4, 5, 6, 7) | 4    | 7     | createList(1, 2, 3, 7, 5, 6, 4)
        createList(1, 2, 3, 4, 5, 6, 7) | 0    | 7     | createList(1, 2, 3, 4, 5, 6, 7)
        createList(1, 2, 3, 4, 5, 6, 7) | 1    | 8     | createList(1, 2, 3, 4, 5, 6, 7)
        createList(1, 2, 3, 4, 5, 6, 7) | 0    | 8     | createList(1, 2, 3, 4, 5, 6, 7)
    }
}
