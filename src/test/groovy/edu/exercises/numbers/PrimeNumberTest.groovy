package edu.exercises.numbers

import spock.lang.Specification
import spock.lang.Unroll

class PrimeNumberTest extends Specification {
    static final def prime = true
    static final def composite = false

    @Unroll
    def 'is prime number (school method)'() {
        given:
        def underTest = new PrimeNumber()

        expect:
        expected == underTest.isPrimeSchoolMethod(num)

        where:
        num        || expected
        1          || composite
        2          || prime
        3          || prime
        4          || composite
        5          || prime
        6          || composite
        7          || prime
        11         || prime
        12         || composite
        13         || prime
        341        || composite
        729        || composite
        2147483647 || prime
    }
}
