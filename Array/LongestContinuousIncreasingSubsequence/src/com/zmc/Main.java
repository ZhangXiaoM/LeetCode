package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,3,5,4,5,6,7};
        System.out.print(findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        int max = 1, cnt = 1;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                cnt ++;
                max = Math.max(max, cnt);
            } else {
                cnt = 1;
            }
        }

        return max;
    }
}
