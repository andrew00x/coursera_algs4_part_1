package edu.exercises.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Isomorphic {
    public static boolean areIsomorphic(String stringOne, String stringTwo) {
        if (stringOne == null || stringTwo == null || stringOne.isEmpty() || stringTwo.isEmpty()
                || stringOne.length() != stringTwo.length()) {
            return false;
        }
        Map<Character, Character> charMap = new HashMap<>();
        Set<Character> visited = new HashSet<>();
        for (int i = 0; i < stringOne.length(); i++) {
            char charOne = stringOne.charAt(i);
            char charTwo = stringTwo.charAt(i);
            Character c = charMap.get(charOne);
            if (c == null) {
                if (!visited.add(charOne)) return false;
                charMap.put(charOne, charTwo);
            } else if (c != charTwo) return false;
        }
        return true;
    }
}
