package edu.coursera.algs41

import org.javatuples.Triplet
import spock.lang.Specification
import spock.lang.Unroll

class ThreeSumTest extends Specification {
    @Unroll("for #input output should be #output")
    def 'find three sum'() {
        def threeSum = new ThreeSum()

        expect:
        def result = threeSum.find3Sums(input as int[], 0)
        output.containsAll(asListOfSet(result))

        where:
        input                || output
        []                   || []
        [1, -1]              || []
        [1, 4, -1]           || []
        [1, 4, 9, 2, 0, -1]  || [[-1, 0, 1] as Set]
        [-1, 0, 1, 2, 3, -4] || [[-4, 1, 3] as Set, [-1, -1, 2] as Set, [-1, 0, 1] as Set]
    }

    def 'fail when input contains duplicates'() {
        def threeSum = new ThreeSum()

        when:
        threeSum.find3Sums([0, 0, 0] as int[], 0)

        then:
        thrown IllegalArgumentException
    }

    def asListOfSet(Iterable<Triplet<Integer, Integer, Integer>> iter) {
        def list = []
        iter.each { arr -> list << arr.toSet() }
        return list
    }
}
