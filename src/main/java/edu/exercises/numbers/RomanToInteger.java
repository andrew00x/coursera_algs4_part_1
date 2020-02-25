package edu.exercises.numbers;

import java.util.Map;

public class RomanToInteger {
    private static Map<Character, Integer> romToInt = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public int toInteger(String roman) {
        int n = 0;
        if (roman.isEmpty()) return n;
        int cur;
        int next;
        for (int i = 0; i < roman.length() - 1; i++) {
            cur = romToInt.get(roman.charAt(i));
            next = romToInt.get(roman.charAt(i + 1));
            if (next > cur) n -= cur;
            else n += cur;
        }
        return n + romToInt.get(roman.charAt(roman.length() - 1));
    }
}
