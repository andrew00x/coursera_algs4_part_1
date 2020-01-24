package algs41

import edu.coursera.algs41.QuickSelect
import edu.coursera.algs41.Util
import spock.lang.Specification

class QuickSelectTest extends Specification {
    def 'select k-th smallest item'() {
        def a = [5, 8, 6, 7, 4, 1, 3, 2, 9] as Integer[]

        expect:
        result == QuickSelect.select(a, k)

        where:
        k || result
        0 || 1
        1 || 2
        6 || 7
    }

    def 'select k-th smallest item from 1000000 items'() {
        def a = readInts('input_1000000.txt')
        assert a.length == 1000000
        assert !Util.isSorted(a)

        when:
        def result = QuickSelect.select(a, 134567)

        then:
        result == 134568
    }

    def 'select k-th smallest item from 1000000 sorted items'() {
        def a = readInts('input_sorted_1000000.txt')
        assert a.length == 1000000
        assert Util.isSorted(a)

        when:
        def result = QuickSelect.select(a, 134567)

        then:
        result == 134568
    }

    private Integer[] readInts(String filename) {
        this.class.classLoader.getResourceAsStream(filename).withReader { input ->
            input.readLines().collect { it as int }
        }
    }
}
