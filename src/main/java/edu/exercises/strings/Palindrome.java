package edu.exercises.strings;

public class Palindrome {
    public boolean isPalindrome(String text) {
        int length = text.length();
        if (length == 0) return true;
        int lo = 0;
        int hi = length - 1;
        while (lo < hi) {
            char c1 = text.charAt(lo);
            char c2 = text.charAt(hi);
            if (!Character.isLetterOrDigit(c1)) {
                lo++;
            } else if (!Character.isLetterOrDigit(c2)) {
                hi--;
            } else {
                if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) return false;
                lo++;
                hi--;
            }
        }
        return true;
    }
}
