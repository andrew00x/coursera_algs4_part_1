package edu.exercises.linked_list

import spock.lang.Specification

import static edu.exercises.linked_list.ListNodeHelper.createList

class PalindromeTest extends Specification {
    def 'test palindrome list'() {
        given:
        def underTest = new Palindrome()

        expect:
        expected == underTest.isPalindrome(input)

        where:
        input                     || expected
        createList(1)             || true
        createList(1, 2)          || false
        createList(1, 2, 3)       || false
        createList(1, 2, 2, 1)    || true
        createList(1, 2, 3, 2, 1) || true
    }
}
