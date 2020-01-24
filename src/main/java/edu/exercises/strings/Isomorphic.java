package edu.exercises.strings;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    public static boolean areIsomorphic(String stringOne, String stringTwo) {
        if (stringOne == null || stringTwo == null || stringOne.isEmpty() || stringTwo.isEmpty()
                || stringOne.length() != stringTwo.length()) {
            return false;
        }
        Map<Character, Character> charMap = new HashMap<>();
        for (int i = 0; i < stringOne.length(); i++) {
            char charOne = stringOne.charAt(i);
            char charTwo = stringTwo.charAt(i);
            if (charOne == charTwo) continue;
            Character c;
            if ((c = charMap.get(charOne)) != null && c != charTwo) {
               return false;
            } else if (c == null) {
                charMap.put(charOne, charTwo);
            }
        }
        return true;
    }
}
