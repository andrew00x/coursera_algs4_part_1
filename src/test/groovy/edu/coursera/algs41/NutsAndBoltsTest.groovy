package edu.coursera.algs41

import edu.coursera.algs41.NutsAndBolts.Bolt
import edu.coursera.algs41.NutsAndBolts.Nut
import edu.coursera.algs41.NutsAndBolts.Pair
import spock.lang.Specification

class NutsAndBoltsTest extends Specification {
    def 'matches nuts and bolts'() {
        def nuts = [new Nut(1), new Nut(4), new Nut(2), new Nut(3), new Nut(5)] as Nut[]
        def bolts = [new Bolt(3), new Bolt(5), new Bolt(2), new Bolt(1), new Bolt(4)] as Bolt[]

        when:
        def pairs = NutsAndBolts.match(nuts, bolts)

        then:
        pairs as List == [new Pair(new Nut(1), new Bolt(1)),
                          new Pair(new Nut(2), new Bolt(2)),
                          new Pair(new Nut(3), new Bolt(3)),
                          new Pair(new Nut(4), new Bolt(4)),
                          new Pair(new Nut(5), new Bolt(5))]
    }
}
