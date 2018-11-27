package edu.coursera.algs41

import spock.lang.Specification

class LinkedStackTest extends Specification {
    def 'new stack is empty'() {
        when:
        def stack = new LinkedStack<Integer>()


        then:
        stack.isEmpty()
    }

    def 'stack created with array is not empty'() {
        when:
        def stack = new LinkedStack<Integer>([1, 2, 3] as Integer[])

        then:
        !stack.isEmpty()
    }

    def 'stack created with iterable is not empty'() {
        when:
        def stack = new LinkedStack<Integer>([1, 2, 3])

        then:
        !stack.isEmpty()
    }

    def 'stack is empty when all items popped'() {
        def stack = new LinkedStack<Integer>([1, 2, 3])
        when:
        stack.pop()
        stack.pop()
        stack.pop()

        then:
        stack.isEmpty()
    }

    def 'size of new stack is zero'() {
        when:
        def stack = new LinkedStack<Integer>()


        then:
        stack.size() == 0
    }

    def 'size of stack created with array'() {
        when:
        def stack = new LinkedStack<Integer>([1, 2, 3] as Integer[])

        then:
        stack.size() == 3
    }

    def 'size of stack created with iterable'() {
        when:
        def stack = new LinkedStack<Integer>([1, 2, 3])

        then:
        stack.size() == 3
    }

    def 'size of stack is zero when all items poped'() {
        def stack = new LinkedStack<Integer>([1, 2, 3])
        when:
        stack.pop()
        stack.pop()
        stack.pop()

        then:
        stack.size() == 0
    }

    def 'push'() {
        def stack = new LinkedStack<Integer>()

        when:
        stack.push(1)

        then:
        stack.size() == 1
    }

    def 'pop'() {
        def stack = new LinkedStack<Integer>([1, 2, 3])

        when:
        def e1 = stack.pop()
        def e2 = stack.pop()

        then:
        e1 == 3
        e2 == 2
        stack.size() == 1
    }

    def 'pop from empty stack'() {
        def stack = new LinkedStack<Integer>()

        when:
        def e = stack.pop()

        then:
        e == null
    }

    def 'iterator of empty stack is empty'() {
        when:
        def stack = new LinkedStack<Integer>()

        then:
        !stack.iterator().hasNext()
    }

    def 'iterator over elements in stack'() {
        def stack = new LinkedStack<Integer>([1, 2, 3])

        when:
        def elements = []
        stack.iterator().each { elements << it }

        then:
        elements == [3, 2, 1]
    }
}
