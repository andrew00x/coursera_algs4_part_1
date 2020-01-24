package edu.coursera.algs41

import spock.lang.Specification

class LinkedDequeTest extends Specification {
    def 'new deque is empty'() {
        when:
        def deque = new LinkedDeque<Integer>()


        then:
        deque.isEmpty()
    }

    def 'deque created with array is not empty'() {
        when:
        def deque = new LinkedDeque<Integer>([1, 2, 3] as Integer[])

        then:
        !deque.isEmpty()
    }

    def 'deque created with iterable is not empty'() {
        when:
        def deque = new LinkedDeque<Integer>([1, 2, 3])

        then:
        !deque.isEmpty()
    }

    def 'deque is empty when all items dequeued'() {
        def deque = new LinkedDeque<Integer>([1, 2, 3])

        when:
        deque.dequeue()
        deque.dequeue()
        deque.dequeue()

        then:
        deque.isEmpty()
    }

    def 'size of new deque is zero'() {
        when:
        def deque = new LinkedDeque<Integer>()


        then:
        deque.size() == 0
    }

    def 'size of deque created with array'() {
        when:
        def deque = new LinkedDeque<Integer>([1, 2, 3] as Integer[])

        then:
        deque.size() == 3
    }

    def 'size of deque created with iterable'() {
        when:
        def deque = new LinkedDeque<Integer>([1, 2, 3])

        then:
        deque.size() == 3
    }

    def 'size of deque is zero when all items dequeued'() {
        def deque = new LinkedDeque<Integer>([1, 2, 3])

        when:
        deque.dequeue()
        deque.dequeue()
        deque.dequeue()

        then:
        deque.size() == 0
    }

    def 'enqueue'() {
        def deque = new LinkedDeque<Integer>()

        when:
        deque.enqueue(1)

        then:
        deque.size() == 1
    }

    def 'add last'() {
        def deque = new LinkedDeque<Integer>()

        when:
        deque.addLast(1)

        then:
        deque.size() == 1
    }

    def 'add first'() {
        def deque = new LinkedDeque<Integer>()

        when:
        deque.addFirst(1)

        then:
        deque.size() == 1
        deque.dequeue() == 1
    }

    def 'dequeue'() {
        def deque = new LinkedDeque<Integer>([1, 2, 3])

        when:
        def e1 = deque.dequeue()
        def e2 = deque.dequeue()

        then:
        e1 == 1
        e2 == 2
        deque.size() == 1
    }

    def 'remove first'() {
        def deque = new LinkedDeque<Integer>([1, 2, 3])

        when:
        def e1 = deque.removeFirst()
        def e2 = deque.removeFirst()

        then:
        e1 == 1
        e2 == 2
        deque.size() == 1
    }

    def 'remove first from empty deque'() {
        def deque = new LinkedDeque<Integer>()

        when:
        def e = deque.removeFirst()

        then:
        e == null
    }

    def 'remove last'() {
        def deque = new LinkedDeque<Integer>([1, 2, 3])

        when:
        def e1 = deque.removeLast()
        def e2 = deque.removeLast()

        then:
        e1 == 3
        e2 == 2
        deque.size() == 1
    }

    def 'dequeue from empty deque'() {
        def deque = new LinkedDeque<Integer>()

        when:
        def e = deque.dequeue()

        then:
        e == null
    }

    def 'remove last from empty deque'() {
        def deque = new LinkedDeque<Integer>()

        when:
        def e = deque.removeLast()

        then:
        e == null
    }

    def 'iterator of empty deque is empty'() {
        when:
        def deque = new LinkedDeque<Integer>()

        then:
        !deque.iterator().hasNext()
    }

    def 'iterator over elements in deque'() {
        def deque = new LinkedDeque<Integer>([1, 2, 3])

        when:
        def elements = []
        deque.iterator().each { elements << it }

        then:
        elements == [1, 2, 3]
    }
}
