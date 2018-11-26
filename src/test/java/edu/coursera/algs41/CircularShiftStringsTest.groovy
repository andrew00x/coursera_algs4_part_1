package edu.coursera.algs41

import spock.lang.Specification
import spock.lang.Unroll

class CircularShiftStringsTest extends Specification {
    @Unroll("for '#a' and '#b' circular shift is #result")
    def 'check strings rotation'() {
        def checker = new CircularShiftStrings();

        expect:
        result == checker.checkRotation(a, b)

        where:
        a            | b            || result
        ''           | ''           || true
        'ab'         | ''           || false
        'ab'         | 'ba'         || true
        'ab'         | 'ac'         || false
        'algorithms' | 'rithmsalgo' || true
    }
}
