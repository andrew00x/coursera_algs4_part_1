package edu.exercises.numbers;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        int x = n;
        while (x != 1 && visited.add(x)) {
            x = sumDigitSquares(x);
        }
        return x == 1;
    }

    private int sumDigitSquares(int n) {
        int x = 0;
        while (n > 0) {
            x += (int) Math.pow(n % 10, 2);
            n /= 10;
        }
        return x;
    }
}
