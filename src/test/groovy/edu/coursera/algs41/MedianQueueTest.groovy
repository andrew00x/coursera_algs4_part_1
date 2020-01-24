package edu.coursera.algs41

import spock.lang.Specification

class MedianQueueTest extends Specification {
    def 'new queue is empty'() {
        when:
        def queue = new MedianQueue()


        then:
        queue.isEmpty()
    }

    def 'queue created with array is not empty'() {
        when:
        def queue = new MedianQueue([1, 2, 3] as int[])

        then:
        !queue.isEmpty()
    }

    def 'queue is empty when all items dequeued'() {
        def queue = new MedianQueue([1, 2, 3] as int[])
        when:
        queue.dequeue()
        queue.dequeue()
        queue.dequeue()

        then:
        queue.isEmpty()
    }

    def 'size of new queue is zero'() {
        when:
        def queue = new MedianQueue()


        then:
        queue.size() == 0
    }

    def 'size of queue created with array'() {
        when:
        def queue = new MedianQueue([1, 2, 3] as int[])

        then:
        queue.size() == 3
    }

    def 'size of queue created with iterable'() {
        when:
        def queue = new MedianQueue([1, 2, 3] as int[])

        then:
        queue.size() == 3
    }

    def 'size of queue is zero when all items dequeued'() {
        def queue = new MedianQueue([1, 2, 3] as int[])
        when:
        queue.dequeue()
        queue.dequeue()
        queue.dequeue()

        then:
        queue.size() == 0
    }

    def 'enqueue'() {
        def queue = new MedianQueue()

        when:
        queue.enqueue(1)

        then:
        queue.size() == 1
    }

    def 'dequeue when size is odd'() {
        def queue = new MedianQueue([1, 2, 3] as int[])

        when:
        def e1 = queue.dequeue()
        def e2 = queue.dequeue()

        then:
        e1 == 2
        e2 == 1
        queue.size() == 1
    }

    def 'dequeue when size is even'() {
        def queue = new MedianQueue([1, 2, 3, 4] as int[])

        when:
        def e1 = queue.dequeue()
        def e2 = queue.dequeue()

        then:
        e1 == 2
        e2 == 3
        queue.size() == 2
    }

    def 'median when size is odd'() {
        def queue = new MedianQueue([1, 2, 3] as int[])

        when:
        def m = queue.median()

        then:
        m == 2
    }

    def 'median when size is even'() {
        def queue = new MedianQueue([1, 2, 3, 4] as int[])

        when:
        def m = queue.median()

        then:
        m == 2.5D
    }

    def 'dequeue from empty queue'() {
        def queue = new MedianQueue()

        when:
        def e = queue.dequeue()

        then:
        e == null
    }

    def 'iterator of empty queue is empty'() {
        when:
        def queue = new MedianQueue()

        then:
        !queue.iterator().hasNext()
    }

    def 'iterator over elements in queue'() {
        def queue = new MedianQueue([1, 2, 3, 4] as int[])

        when:
        def elements = []
        queue.iterator().each { elements << it }

        then:
        with(elements) {
            size() == 4
            containsAll([1, 2, 3, 4])
        }
    }
}
