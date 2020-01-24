package edu.exercises.bits;

public class ComplementNumber {
    public static int $(int num) {
        int result = 0;
        int mask = 1;
        while (mask > 0 && mask < num) {
            result += (num & mask) ^ mask;
            mask <<= 1;
        }
        return result;
    }
}
