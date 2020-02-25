package edu.exercises.numbers

import spock.lang.Specification
import spock.lang.Unroll

class RomanToIntegerTest extends Specification {
    @Unroll
    def 'roman number to integer'() {
        given:
        def underTest = new RomanToInteger()

        expect:
        expected == underTest.toInteger(roman)

        where:
        roman   || expected
        'I'     || 1
        'II'    || 2
        'III'   || 3
        'IIII'  || 4
        'IV'    || 4
        'VII'   || 7
        'LVIII' || 58
        'MMXX'  || 2020
    }
}
