package edu.coursera.algs41

import spock.lang.Specification

class UnorderedMaxPriorityQueueTest extends Specification {
    def 'new queue is empty'() {
        when:
        def queue = new UnorderedMaxPriorityQueue<Integer>(10)


        then:
        queue.isEmpty()
    }

    def 'queue is empty when all items dequeued'() {
        def queue = new UnorderedMaxPriorityQueue<Integer>(10)
        queue.enqueue(1)
        queue.enqueue(2)

        when:
        queue.dequeue()
        queue.dequeue()

        then:
        queue.isEmpty()
    }

    def 'size of new queue is zero'() {
        when:
        def queue = new UnorderedMaxPriorityQueue<Integer>(10)

        then:
        queue.size() == 0
    }

    def 'size of queue is zero when all items dequeued'() {
        def queue = new UnorderedMaxPriorityQueue<Integer>(10)
        queue.enqueue(1)
        queue.enqueue(2)

        when:
        queue.dequeue()
        queue.dequeue()
        queue.dequeue()

        then:
        queue.size() == 0
    }

    def 'enqueue'() {
        def queue = new UnorderedMaxPriorityQueue<Integer>(10)

        when:
        queue.enqueue(1)

        then:
        queue.size() == 1
    }

    def 'dequeue'() {
        def queue = new UnorderedMaxPriorityQueue<Integer>(10)
        queue.enqueue(1)
        queue.enqueue(2)

        when:
        def e1 = queue.dequeue()
        def e2 = queue.dequeue()

        then:
        e1 == 2
        e2 == 1
    }

    def 'sample'() {
        def queue = new UnorderedMaxPriorityQueue<Integer>(10)
        queue.enqueue(1)
        queue.enqueue(2)

        when:
        def e1 = queue.sample()
        def e2 = queue.sample()

        then:
        e1 == 2
        e2 == 2
    }

    def 'dequeue from empty queue'() {
        def queue = new UnorderedMaxPriorityQueue<Integer>(10)

        when:
        def e = queue.dequeue()

        then:
        e == null
    }

    def 'iterator of empty queue is empty'() {
        when:
        def queue = new UnorderedMaxPriorityQueue<Integer>(10)

        then:
        !queue.iterator().hasNext()
    }

    def 'iterator over elements in queue'() {
        def queue = new UnorderedMaxPriorityQueue<Integer>(10)
        queue.enqueue(2)
        queue.enqueue(1)
        queue.enqueue(3)

        when:
        def elements = []
        queue.iterator().each { elements << it }

        then:
        elements == [2, 1, 3]
    }
}
