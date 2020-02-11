package edu.exercises.numbers

import spock.lang.Specification
import spock.lang.Unroll

class ExcelSheetNumberTest extends Specification {
    @Unroll
    def 'number to sheet title'() {
        given:
        def underTest = new ExcelSheetNumber()

        expect:
        expected == underTest.toSheetTitle(num)

        where:
        num || expected
        1   || 'A'
        26  || 'Z'
        28  || 'AB'
        702 || 'ZZ'
    }

    @Unroll
    def 'sheet title to number'() {
        given:
        def underTest = new ExcelSheetNumber()

        expect:
        expected == underTest.toNumber(title)

        where:
        title || expected
        'A'   || 1
        'Z'   || 26
        'AB'  || 28
        'ZZ'  || 702
    }
}
