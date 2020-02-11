package edu.exercises.array

import spock.lang.Specification
import spock.lang.Unroll

class SingleNumberTest extends Specification {
    @Unroll
    def "single number hash"() {
        given:
        def underTest = new SingleNumber()

        expect:
        expected == underTest.singleNumberHash(nums)

        where:
        nums                     || expected
        [2, 3, 3, 1, 2] as int[] || 1
        [4, 1, 2, 1, 2] as int[] || 4
    }

    @Unroll
    def "single number math"() {
        given:
        def underTest = new SingleNumber()

        expect:
        expected == underTest.singleNumberMath(nums)

        where:
        nums                     || expected
        [2, 3, 3, 1, 2] as int[] || 1
        [4, 1, 2, 1, 2] as int[] || 4
    }

    @Unroll
    def "single number bit"() {
        given:
        def underTest = new SingleNumber()

        expect:
        expected == underTest.singleNumberBit(nums)

        where:
        nums                     || expected
        [2, 3, 3, 1, 2] as int[] || 1
        [4, 1, 2, 1, 2] as int[] || 4
    }
}
