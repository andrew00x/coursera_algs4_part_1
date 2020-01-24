package algs41

import edu.coursera.algs41.MinMaxPriorityQueue
import spock.lang.Specification

class MinMaxPriorityQueueTest extends Specification {
    def 'new queue is empty'() {
        when:
        def queue = new MinMaxPriorityQueue<Integer>()

        then:
        queue.isEmpty()
    }

    def 'queue is empty when all items dequeued'() {
        def queue = new MinMaxPriorityQueue<Integer>()
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
        def queue = new MinMaxPriorityQueue<Integer>()

        then:
        queue.size() == 0
    }

    def 'size of queue is zero when all items dequeued'() {
        def queue = new MinMaxPriorityQueue<Integer>()
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
        def queue = new MinMaxPriorityQueue<Integer>()

        when:
        queue.enqueue(1)

        then:
        queue.size() == 1
    }

    def 'dequeue from max queue'() {
        def queue = new MinMaxPriorityQueue<Integer>()
        queue.enqueue(1)
        queue.enqueue(2)

        when:
        def e1 = queue.dequeue()
        def e2 = queue.dequeue()

        then:
        e1 == 2
        e2 == 1
    }

    def 'dequeue from min queue'() {
        def queue = new MinMaxPriorityQueue<Integer>(true)
        queue.enqueue(1)
        queue.enqueue(2)

        when:
        def e1 = queue.dequeue()
        def e2 = queue.dequeue()

        then:
        e1 == 1
        e2 == 2
    }

    def 'sample from max queue'() {
        def queue = new MinMaxPriorityQueue<Integer>()
        queue.enqueue(1)
        queue.enqueue(2)

        when:
        def e1 = queue.sample()
        def e2 = queue.sample()

        then:
        e1 == 2
        e2 == 2
    }

    def 'sample from min queue'() {
        def queue = new MinMaxPriorityQueue<Integer>(true)
        queue.enqueue(1)
        queue.enqueue(2)

        when:
        def e1 = queue.sample()
        def e2 = queue.sample()

        then:
        e1 == 1
        e2 == 1
    }

    def 'dequeue from empty queue'() {
        def queue = new MinMaxPriorityQueue<Integer>()

        when:
        def e = queue.dequeue()

        then:
        e == null
    }

    def 'iterator of empty queue is empty'() {
        when:
        def queue = new MinMaxPriorityQueue<Integer>()

        then:
        !queue.iterator().hasNext()
    }

    def 'iterator over elements in max queue'() {
        def queue = new MinMaxPriorityQueue<Integer>()
        queue.enqueue(2)
        queue.enqueue(4)
        queue.enqueue(5)
        queue.enqueue(3)
        queue.enqueue(1)

        when:
        def elements = []
        queue.iterator().each { elements << it }

        then:
        elements == [5, 4, 3, 2, 1]
    }

    def 'iterator over elements in min queue'() {
        def queue = new MinMaxPriorityQueue<Integer>(true)
        queue.enqueue(2)
        queue.enqueue(4)
        queue.enqueue(5)
        queue.enqueue(3)
        queue.enqueue(1)

        when:
        def elements = []
        queue.iterator().each { elements << it }

        then:
        elements == [1, 2, 3, 4, 5]
    }
}
