package edu.exercises.bits;

public class HammingDistance {
    public static int $(int x, int y) {
        int xor = x ^ y;
        int hDistance = 0;
        while (xor != 0) {
            hDistance += xor & 1;
            xor >>= 1;
        }
        return hDistance;
    }
}
