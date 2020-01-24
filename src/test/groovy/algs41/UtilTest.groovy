package algs41

import edu.coursera.algs41.Util
import spock.lang.Specification

class UtilTest extends Specification {
    def 'swap'() {
        def a = [2, 3, 4, 6, 1] as Integer[]

        when:
        Util.swap(a, 1, 3)

        then:
        a.toList() == [2, 6, 4, 3, 1]
    }

    def 'less'() {
        when:
        def a = 9
        def b = 1

        then:
        !Util.less(a, b)
        Util.less(b, a)
    }

    def 'is sorted'() {
        expect:
        result == Util.isSorted(list as Integer[])

        where:
        list            || result
        [1, 2, 2, 3, 3] || true
        [1, 2, 3, 4, 5] || true
        [1, 3, 5, 6, 8] || true
        [1, 3, 6, 5, 8] || false
        [5, 4, 3, 2, 1] || false
    }

    def 'median'() {
        expect:
        result == Util.median(list as Integer[], i, j, k)

        where:
        list            | i | j | k || result
        [1, 3, 2, 5, 7] | 0 | 2 | 3  | 2
        [1, 3, 2, 5, 7] | 1 | 2 | 3  | 2
        [1, 3, 2, 5, 7] | 4 | 1 | 3  | 1
    }
}
