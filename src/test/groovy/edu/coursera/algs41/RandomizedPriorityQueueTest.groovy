package edu.coursera.algs41

import spock.lang.Specification

class RandomizedPriorityQueueTest extends Specification {
    def 'new queue is empty'() {
        when:
        def queue = new RandomizedPriorityQueue<Integer>()


        then:
        queue.isEmpty()
    }

    def 'queue created with iterable is not empty'() {
        when:
        def queue = new RandomizedPriorityQueue<Integer>([1, 2, 3])

        then:
        !queue.isEmpty()
    }

    def 'queue is empty when all items dequeued'() {
        def queue = new RandomizedPriorityQueue<Integer>([1, 2, 3])
        when:
        queue.dequeue()
        queue.dequeue()
        queue.dequeue()

        then:
        queue.isEmpty()
    }

    def 'size of new queue is zero'() {
        when:
        def queue = new RandomizedPriorityQueue<Integer>()


        then:
        queue.size() == 0
    }

    def 'size of queue created with iterable'() {
        when:
        def queue = new RandomizedPriorityQueue<Integer>([1, 2, 3])

        then:
        queue.size() == 3
    }

    def 'size of queue is zero when all items dequeued'() {
        def queue = new RandomizedPriorityQueue<Integer>([1, 2, 3])
        when:
        queue.dequeue()
        queue.dequeue()
        queue.dequeue()

        then:
        queue.size() == 0
    }

    def 'enqueue'() {
        def queue = new RandomizedPriorityQueue<Integer>()

        when:
        queue.enqueue(1)

        then:
        queue.size() == 1
    }

    def 'dequeue'() {
        def queue = new RandomizedPriorityQueue<Integer>([1, 2, 3])

        when:
        def e1 = queue.dequeue()
        def e2 = queue.dequeue()

        then:
        e1 == 3
        e2 == 2
        queue.size() == 1
    }

    def 'dequeue from empty queue'() {
        def queue = new RandomizedPriorityQueue<Integer>()

        when:
        def e = queue.dequeue()

        then:
        e == null
    }

    def 'sample'() {
        def queue = new RandomizedPriorityQueue<Integer>()
        queue.enqueue(1)
        queue.enqueue(2)

        when:
        def e1 = queue.sample()
        def e2 = queue.sample()

        then:
        e1 in [1, 2]
        e2 in [1, 2]
    }

    def 'delete random'() {
        def queue = new RandomizedPriorityQueue<Integer>([1, 2, 3])

        when:
        def e1 = queue.delRandom()
        def e2 = queue.delRandom()

        then:
        e1 in [1, 2, 3]
        e2 in [1, 2, 3] - [e1]
        queue.size() == 1
    }

    def 'iterator of empty queue is empty'() {
        when:
        def queue = new RandomizedPriorityQueue<Integer>()

        then:
        !queue.iterator().hasNext()
    }

    def 'iterator over elements in queue'() {
        def queue = new RandomizedPriorityQueue<Integer>([1, 2, 3])

        when:
        def elements = []
        queue.iterator().each { elements << it }

        then:
        elements == [3, 2, 1]
    }
}
