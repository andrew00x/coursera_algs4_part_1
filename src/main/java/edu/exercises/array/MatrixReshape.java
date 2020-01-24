package edu.exercises.array;

public class MatrixReshape {
    public static int[][] $(int[][] matrix, int r, int c) {
        int h = matrix.length;
        int w = matrix[0].length;
        if (r * c != h * w) {
            return matrix;
        }
        int[][] reshaped = new int[r][c];
        for (int i = 0, s = r * c; i < s; i++) {
            reshaped[i / c][i % c] = matrix[i / w][i % w];
        }
        return reshaped;
    }
}
