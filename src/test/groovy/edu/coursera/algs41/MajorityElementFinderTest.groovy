package edu.coursera.algs41

import spock.lang.Specification
import spock.lang.Unroll

class MajorityElementFinderTest extends Specification {
    @Unroll
    def 'find majority elements'() {
        def dd = []
        new MajorityElementFinder(ratio).findMajorityElements(a).each { dd << it }

        expect:
        dd == result

        where:
        a                                                                | ratio || result
        [1, 8, 2, 3, 1, 2, 0, 5, 2, 1, 1, 2, 4, 9, 7, 9, 2] as Integer[] | 2      | []
        [1, 8, 1, 1, 1, 2, 0, 1, 2, 1, 1, 2, 4, 1, 1, 9, 2] as Integer[] | 2      | [1]
        [1, 8, 2, 3, 1, 2, 0, 5, 2, 1, 1, 2, 4, 9, 7, 9, 2] as Integer[] | 10     | [1, 2, 9]
    }
}
