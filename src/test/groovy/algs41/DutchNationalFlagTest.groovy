package algs41

import edu.coursera.algs41.DutchNationalFlag
import spock.lang.Specification

import static edu.coursera.algs41.DutchNationalFlag.Pebble

class DutchNationalFlagTest extends Specification {
    def 'dutch national flag'() {
        def pebbles = [Pebble.BLUE,
                       Pebble.WHITE,
                       Pebble.BLUE,
                       Pebble.RED,
                       Pebble.WHITE,
                       Pebble.RED,
                       Pebble.RED,
                       Pebble.BLUE,
                       Pebble.WHITE,
                       Pebble.WHITE] as Pebble[]

        when:
        new DutchNationalFlag().dutchNationalFlag(pebbles)

        then:
        pebbles as List == [Pebble.RED, Pebble.RED, Pebble.RED,
                            Pebble.WHITE, Pebble.WHITE, Pebble.WHITE, Pebble.WHITE,
                            Pebble.BLUE, Pebble.BLUE, Pebble.BLUE]
    }
}
