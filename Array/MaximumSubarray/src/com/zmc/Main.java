
/*

https://leetcode.com/problems/maximum-subarray/description/

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(maxSubArray(nums));

    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}
