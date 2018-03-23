
/*

https://leetcode.com/problems/house-robber/description/

You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.


 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {100, 1, 1, 20, 40};
        System.out.print(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; ++i) {
            dp[i] = Math.max(dp[i - 2], i > 2? dp[i - 3] : 0) + nums[i];
        }
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }
}
