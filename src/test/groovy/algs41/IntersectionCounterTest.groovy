package algs41

import edu.coursera.algs41.IntersectionCounter
import edu.princeton.cs.algs4.Point2D
import spock.lang.Specification

class IntersectionCounterTest extends Specification {
    def 'count intersection'() {
        def a = [new Point2D(0.1, 0.1), new Point2D(0.2, 0.2), new Point2D(0.3, 0.3), new Point2D(0.4, 0.4)] as Point2D[]
        def b = [new Point2D(0.4, 0.4), new Point2D(0.5, 0.5), new Point2D(0.2, 0.2), new Point2D(0.7, 0.7)] as Point2D[]

        when:
        def c = new IntersectionCounter().countIntersection(a, b)

        then:
        c == 2
    }
}
