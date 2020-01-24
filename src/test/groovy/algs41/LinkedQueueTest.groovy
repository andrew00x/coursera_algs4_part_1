package algs41

import edu.coursera.algs41.LinkedQueue
import spock.lang.Specification

class LinkedQueueTest extends Specification {
    def 'new queue is empty'() {
        when:
        def queue = new LinkedQueue<Integer>()


        then:
        queue.isEmpty()
    }

    def 'queue created with array is not empty'() {
        when:
        def queue = new LinkedQueue<Integer>([1, 2, 3] as Integer[])

        then:
        !queue.isEmpty()
    }

    def 'queue created with iterable is not empty'() {
        when:
        def queue = new LinkedQueue<Integer>([1, 2, 3])

        then:
        !queue.isEmpty()
    }

    def 'queue is empty when all items dequeued'() {
        def queue = new LinkedQueue<Integer>([1, 2, 3])
        when:
        queue.dequeue()
        queue.dequeue()
        queue.dequeue()

        then:
        queue.isEmpty()
    }

    def 'size of new queue is zero'() {
        when:
        def queue = new LinkedQueue<Integer>()


        then:
        queue.size() == 0
    }

    def 'size of queue created with array'() {
        when:
        def queue = new LinkedQueue<Integer>([1, 2, 3] as Integer[])

        then:
        queue.size() == 3
    }

    def 'size of queue created with iterable'() {
        when:
        def queue = new LinkedQueue<Integer>([1, 2, 3])

        then:
        queue.size() == 3
    }

    def 'size of queue is zero when all items dequeued'() {
        def queue = new LinkedQueue<Integer>([1, 2, 3])
        when:
        queue.dequeue()
        queue.dequeue()
        queue.dequeue()

        then:
        queue.size() == 0
    }

    def 'enqueue'() {
        def queue = new LinkedQueue<Integer>()

        when:
        queue.enqueue(1)

        then:
        queue.size() == 1
    }

    def 'dequeue'() {
        def queue = new LinkedQueue<Integer>([1, 2, 3])

        when:
        def e1 = queue.dequeue()
        def e2 = queue.dequeue()

        then:
        e1 == 1
        e2 == 2
        queue.size() == 1
    }

    def 'dequeue from empty queue'() {
        def queue = new LinkedQueue<Integer>()

        when:
        def e = queue.dequeue()

        then:
        e == null
    }

    def 'iterator of empty queue is empty'() {
        when:
        def queue = new LinkedQueue<Integer>()

        then:
        !queue.iterator().hasNext()
    }

    def 'iterator over elements in queue'() {
        def queue = new LinkedQueue<Integer>([1, 2, 3])

        when:
        def elements = []
        queue.iterator().each { elements << it }

        then:
        elements == [1, 2, 3]
    }
}
