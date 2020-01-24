package edu.exercises.numbers;

public class Fib {
    public static long f(int num) {
        if (num < 2) {
            return num;
        }
        long a = 1;
        long b = 1;
        for (int i = 2; i < num; i++) {
            long s = a + b;
            a = b;
            b = s;
        }
        return b;
    }
}
