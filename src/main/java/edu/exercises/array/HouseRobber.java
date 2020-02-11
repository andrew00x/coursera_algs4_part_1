package edu.exercises.array;

public class HouseRobber {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        int s1 = nums[0];
        int s2 = Math.max(nums[0], nums[1]);
        int max = 0;
        for (int i = 2; i < len; i++) {
            max = Math.max(s2, s1 + nums[i]);
            s1 = s2;
            s2 = max;
        }
        return max;
    }
}
