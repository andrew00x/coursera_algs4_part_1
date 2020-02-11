package edu.exercises.array

import spock.lang.Specification
import spock.lang.Unroll

class HouseRobberTest extends Specification {
    @Unroll
    def 'house robber'() {
        given:
        def underTest = new HouseRobber()

        expect:
        expected == underTest.rob(houses as int[])

        where:
        houses          || expected
        [3]             || 3
        [3, 1]          || 3
        [1, 3]          || 3
        [1, 3]          || 3
        [1, 5, 3]       || 5
        [1, 5, 3, 3, 1] || 8
    }
}
