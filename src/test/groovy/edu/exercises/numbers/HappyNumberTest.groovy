package edu.exercises.numbers

import spock.lang.Specification
import spock.lang.Unroll

class HappyNumberTest extends Specification {
    static def happy = true
    static def unhappy = false

    @Unroll
    def 'is happy number'() {
        given:
        def underTest = new HappyNumber()

        expect:
        expected == underTest.isHappy(num)

        where:
        num || expected
        19  || happy
        18  || unhappy
        13  || happy
    }
}
