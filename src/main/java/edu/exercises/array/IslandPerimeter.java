package edu.exercises.array;

public class IslandPerimeter {
    public static int $(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        int res = 0;
        for (int k = 0, s = h * w; k < s; k++) {
            int i = k / w;
            int j = k % w;
            if (grid[i][j] == 1) {
                if (j == 0 || grid[i][j - 1] != 1) {
                    res += 2;
                }
                if (i == 0 || grid[i - 1][j] != 1) {
                    res += 2;
                }
            }
        }
        return res;
    }
}
