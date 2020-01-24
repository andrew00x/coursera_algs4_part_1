package algs41

import edu.coursera.algs41.BitonicArraySearch
import spock.lang.Specification

class BitonicArraySearchTest extends Specification {
    def 'find value'() {
        def arr = [6, 7, 8, 11, 9, 5, 2, 1] as int[]
        def search = new BitonicArraySearch(arr)

        expect:
        search.find(val) == expected

        where:
        val || expected
        3   || -1
        7   || 1
        2   || 6
    }

    def 'fail when input array is not bitonic'() {
        when:
        def arr = [1, 2, 3, 4] as int[]
        new BitonicArraySearch(arr)

        then:
        thrown IllegalArgumentException
    }
}
