package edu.exercises.linked_list

import spock.lang.Specification

import static edu.exercises.linked_list.ListNodeHelper.createList

class MiddleTest extends Specification {
    def 'find middle'() {
        given:
        def underTest = new Middle()

        expect:
        expected == underTest.middle(input)

        where:
        input                     || expected
        createList(1, 2, 3, 4)    || createList(3, 4)
        createList(1, 2, 3, 4, 5) || createList(4, 5)
    }
}
