package algs41

import edu.coursera.algs41.NutsAndBolts
import spock.lang.Specification

class NutsAndBoltsTest extends Specification {
    def 'matches nuts and bolts'() {
        def nuts = [new NutsAndBolts.Nut(1), new NutsAndBolts.Nut(4), new NutsAndBolts.Nut(2), new NutsAndBolts.Nut(3), new NutsAndBolts.Nut(5)] as NutsAndBolts.Nut[]
        def bolts = [new NutsAndBolts.Bolt(3), new NutsAndBolts.Bolt(5), new NutsAndBolts.Bolt(2), new NutsAndBolts.Bolt(1), new NutsAndBolts.Bolt(4)] as NutsAndBolts.Bolt[]

        when:
        def pairs = NutsAndBolts.match(nuts, bolts)

        then:
        pairs as List == [new NutsAndBolts.Pair(new NutsAndBolts.Nut(1), new NutsAndBolts.Bolt(1)),
                          new NutsAndBolts.Pair(new NutsAndBolts.Nut(2), new NutsAndBolts.Bolt(2)),
                          new NutsAndBolts.Pair(new NutsAndBolts.Nut(3), new NutsAndBolts.Bolt(3)),
                          new NutsAndBolts.Pair(new NutsAndBolts.Nut(4), new NutsAndBolts.Bolt(4)),
                          new NutsAndBolts.Pair(new NutsAndBolts.Nut(5), new NutsAndBolts.Bolt(5))]
    }
}
