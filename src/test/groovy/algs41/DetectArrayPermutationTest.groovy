package algs41

import edu.coursera.algs41.DetectArrayPermutation
import spock.lang.Specification

class DetectArrayPermutationTest extends Specification {
    @SuppressWarnings("GroovyPointlessBoolean")
    def 'detect permutations'() {
        expect:
        result == new DetectArrayPermutation().isPermuted(a, b)

        where:
        a                      | b                         || result
        [1, 2, 3] as Integer[] | [3, 1, 2] as Integer[]    || true
        [1, 2, 3] as Integer[] | [1, 2, 0] as Integer[]    || false
        [1, 2, 3] as Integer[] | [1, 2, 3, 4] as Integer[] || false
    }
}
