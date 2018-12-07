package edu.coursera.algs41

import spock.lang.Specification

class CountInversionsTest extends Specification {
    def 'count inversions in array'() {
        expect:
        result == CountInversions.inversions(array as Integer[])

        where:
        array            || result
        [1, 2, 3, 4, 5]  || 0
        [1, 20, 6, 4, 5] || 5
        [5, 4, 3, 2, 1]  || 10
    }
}
