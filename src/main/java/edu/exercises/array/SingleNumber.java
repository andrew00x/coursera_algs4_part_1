package edu.exercises.array;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public int singleNumberHash(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (!s.remove(num)) s.add(num);
        }
        return s.iterator().next();
    }

    public int singleNumberMath(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int s1 = 0;
        int s2 = 0;
        for (int num : nums) {
            s1 += num;
            if (s.add(num)) s2 += num;
        }
        return 2 * s2 - s1;
    }

    public int singleNumberBit(int[] nums) {
        int answ = nums[0];
        for (int i = 1; i < nums.length; i++) {
            answ ^= nums[i];
        }
        return answ;
    }
}
