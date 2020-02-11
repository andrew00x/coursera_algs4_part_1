package edu.exercises.linked_list

import spock.lang.Specification
import spock.lang.Unroll

class MinStackTest extends Specification {
    @Unroll
    def 'min stack'() {
        given:
        def underTest = new MinStack()

        when:
        for (n in nums) {
            underTest.push(n)
        }

        then:
        min == underTest.getMin()
        top == underTest.top()
        underTest.pop()
        min2 == underTest.getMin()

        where:
        nums                 || min | top | min2
        [1, -2, 3, 0, -3, 5] || -3  | 5   | -3
        [1, -2, 3, 0, 5, -3] || -3  | -3  | -2
    }
}
