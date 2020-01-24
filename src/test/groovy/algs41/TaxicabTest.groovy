package algs41

import edu.coursera.algs41.Taxicab
import spock.lang.Specification

class TaxicabTest extends Specification {
    def 'find taxicab numbers'() {
        def taxicab = new Taxicab(n)

        expect:
        taxicab.findNumbers().collect { it.taxicab } == t

        where:
        n  || t
        12 || [1729]
        16 || [1729, 4104]
    }
}
