package edu.coursera.algs41;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import org.javatuples.Pair;

import java.util.Arrays;

public class ClosestPoints {
    private Point2D[] points;
    private Point2D point1, point2;
    private double minDistance = Double.POSITIVE_INFINITY;

    public ClosestPoints(Point2D[] points) {
        if (points.length < 2) throw new IllegalArgumentException();
        this.points = points;
    }

    public Pair<Point2D, Point2D> bruteForce() {
        reset();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = points[i].distanceTo(points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                    point1 = points[i];
                    point2 = points[j];
                }
            }
        }
        return new Pair<>(point1, point2);
    }

    public Pair<Point2D, Point2D> divideAndConquer() {
        reset();
        Point2D[] sortedX = new Point2D[points.length];
        System.arraycopy(points, 0, sortedX, 0, points.length);
        Arrays.sort(sortedX, Point2D.X_ORDER);

        for (int i = 0; i < sortedX.length - 1; i++) {
            if (sortedX[i].equals(sortedX[i + 1])) return new Pair<>(sortedX[i], sortedX[i + 1]);
        }

        Point2D[] sortedY = new Point2D[points.length];
        System.arraycopy(sortedX, 0, sortedY, 0, points.length);

        Point2D[] candidates = new Point2D[points.length];

        closest(sortedX, sortedY, candidates, 0, points.length - 1);
        return new Pair<>(point1, point2);
    }

    private double closest(Point2D[] sortedX, Point2D[] sortedY, Point2D[] candidates, int lo, int hi) {
        if (hi <= lo) return Double.POSITIVE_INFINITY;

        int mid = lo + (hi - lo) / 2;
        double minLeft = closest(sortedX, sortedY, candidates, lo, mid);
        double minRight = closest(sortedX, sortedY, candidates, mid + 1, hi);
        double min = Math.min(minLeft, minRight);

        Arrays.sort(sortedY, lo, hi, Point2D.Y_ORDER);
        Point2D median = sortedX[mid];
        int k = 0;
        for (int i = lo; i <= hi; i++) {
            if (Math.abs(sortedY[i].x() - median.x()) < min) candidates[k++] = sortedY[i];
        }

        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k && Math.abs(candidates[j].y() - candidates[i].y()) < min; j++) {
                double distance = candidates[i].distanceTo(candidates[j]);
                if (distance < min) min = distance;
                if (distance < minDistance) {
                    point1 = candidates[i];
                    point2 = candidates[j];
                    minDistance = distance;
                }
            }
        }
        return min;
    }

    private void reset() {
        point1 = point2 = null;
        minDistance = Double.POSITIVE_INFINITY;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        double[] coordinates = in.readAllDoubles();
        if (coordinates.length % 2 != 0) throw new IllegalArgumentException();
        Point2D[] points = new Point2D[coordinates.length / 2];
        for (int i = 0; i < points.length; i++) points[i] = new Point2D(coordinates[i + 1], coordinates[i + i + 1]);

        ClosestPoints closestPoints = new ClosestPoints(points);

        Stopwatch timer = new Stopwatch();
        Pair<Point2D, Point2D> result = closestPoints.bruteForce();
        StdOut.printf("ClosestPoints (Brute force)        : %s - %s, distance: %.6f\n",
                result.getValue0(), result.getValue1(), result.getValue0().distanceTo(result.getValue1()));
        StdOut.printf("elapsed time = %f sec\n", timer.elapsedTime());

        timer = new Stopwatch();
        result = closestPoints.divideAndConquer();
        StdOut.printf("ClosestPoints (Divide And Conquer) : %s - %s, distance: %.6f\n",
                result.getValue0(), result.getValue1(), result.getValue0().distanceTo(result.getValue1()));
        StdOut.printf("elapsed time = %f sec\n", timer.elapsedTime());
    }
}
