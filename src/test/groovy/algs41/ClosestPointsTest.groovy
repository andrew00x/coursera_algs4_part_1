package algs41

import edu.coursera.algs41.ClosestPoints
import edu.princeton.cs.algs4.Point2D
import spock.lang.Specification

class ClosestPointsTest extends Specification {

    Point2D[] points
    def a
    def b

    def setup() {
        def p = { double a, double b -> new Point2D(a, b) }
        points = [p(0.24, 0.47), p(0.22, 0.93), p(0.94, 0.21), p(0.54, 0.17), p(0.47, 0.81)] as Point2D[]
        a = points[1]
        b = points[4]
    }

    def 'brute force'() {
        def closestPoints = new ClosestPoints(points)

        when:
        def result = closestPoints.bruteForce()

        then:
        with(result) {
            value0 == a || value1 == a
            value1 == b || value0 == b
        }
    }

    def 'divide and conquer'() {
        def closestPoints = new ClosestPoints(points)

        when:
        def result = closestPoints.divideAndConquer()

        then:
        with(result) {
            value0 == a || value1 == a
            value1 == b || value0 == b
        }
    }
}
