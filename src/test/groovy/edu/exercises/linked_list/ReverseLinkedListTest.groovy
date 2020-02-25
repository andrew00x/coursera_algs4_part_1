package edu.exercises.linked_list

import spock.lang.Specification
import spock.lang.Unroll

import static edu.exercises.linked_list.ListNodeHelper.createList

class ReverseLinkedListTest extends Specification {
    @Unroll
    def 'reverse linked list'() {
        given:
        def underTest = new ReverseLinkedList()

        expect:
        expected == underTest.reverse(input)

        where:
        input                           || expected
        createList(1)                   || createList(1)
        createList(1, 2)                || createList(2, 1)
        createList(1, 2, 3)             || createList(3, 2, 1)
        createList(1, 2, 3, 4, 5, 6, 7) || createList(7, 6, 5, 4, 3, 2, 1)
    }

    @Unroll
    def 'copy reverse linked list'() {
        given:
        def underTest = new ReverseLinkedList()

        when:
        def reversed = underTest.copyReverse(input)
        def c = input
        while (c != null) {
            c.value = null
            c = c.next
        }

        then:
        expected == reversed

        where:
        input                           || expected
        createList(1)                   || createList(1)
        createList(1, 2)                || createList(2, 1)
        createList(1, 2, 3)             || createList(3, 2, 1)
        createList(1, 2, 3, 4, 5, 6, 7) || createList(7, 6, 5, 4, 3, 2, 1)
    }

    @Unroll
    def 'recursive reverse linked list'() {
        given:
        def underTest = new ReverseLinkedList()

        expect:
        expected == underTest.reverseRecursive(input)

        where:
        input                           || expected
        createList(1)                   || createList(1)
        createList(1, 2)                || createList(2, 1)
        createList(1, 2, 3)             || createList(3, 2, 1)
        createList(1, 2, 3, 4, 5, 6, 7) || createList(7, 6, 5, 4, 3, 2, 1)
    }
}
