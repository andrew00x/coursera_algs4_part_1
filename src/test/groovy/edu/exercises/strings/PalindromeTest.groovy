package edu.exercises.strings

import spock.lang.Specification
import spock.lang.Unroll

class PalindromeTest extends Specification {
    @Unroll
    def 'test palindrome string'() {
        given:
        def underTest = new Palindrome()

        expect:
        expected == underTest.isPalindrome(text)

        where:
        text                             || expected
        'abba'                           || true
        'bba'                            || false
        'A man, a plan, a canal: Panama' || true
        '0X'                             || false
    }
}
