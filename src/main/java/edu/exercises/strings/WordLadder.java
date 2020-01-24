package edu.exercises.strings;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    public static List<String> ladder(String start, String end, Set<String> dictionary) {
        Queue<Ladder> queue = new LinkedList<>();
        Set<String> checked = new HashSet<>();
        queue.add(new Ladder(start));
        checked.add(start);
        while (!queue.isEmpty()) {
            Ladder ladder = queue.remove();
            String lastWordInLadder = ladder.getLastWord();
            if (lastWordInLadder.equals(end)) {
                System.out.printf("RESULT: %s%n", ladder);
                return ladder.hops;
            }
            for (String newWord : getOneCharDifferWords(lastWordInLadder, dictionary)) {
                if (checked.add(newWord)) {
                    queue.add(new Ladder(ladder, newWord));
                }
            }
        }
        return new ArrayList<>();
    }

    static class Ladder {
        List<String> hops = new ArrayList<>();

        Ladder(String word) {
            hops.add(word);
        }

        Ladder(Ladder other, String word) {
            hops.addAll(other.hops);
            hops.add(word);
        }

        String getLastWord() {
            return Iterables.getLast(hops);
        }

        @Override
        public String toString() {
            return Joiner.on(" -> ").join(hops);
        }
    }

    private static List<String> getOneCharDifferWords(String word, Set<String> dictionary) {
        char[] chars = word.toCharArray();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            for (char replacementChar = 'a'; replacementChar <= 'z'; replacementChar++) {
                if (currentChar != replacementChar) {
                    chars[i] = replacementChar;
                    String newWord = new String(chars);
                    if (dictionary.contains(newWord)) {
                        result.add(newWord);
                    }
                }
            }
            chars[i] = currentChar;
        }
        return result;
    }
}
