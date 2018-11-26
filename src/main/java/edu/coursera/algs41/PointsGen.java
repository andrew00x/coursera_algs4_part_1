package edu.coursera.algs41;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class PointsGen {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = 0;
        Point2D[] points = new Point2D[n];
        while (k < n) points[k++] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
        for (Point2D point : points) StdOut.printf("%.6f %.6f\n", point.x(), point.y());
    }
}
