
/*

https://leetcode.com/problems/continuous-subarray-sum/description/

Given a list of non-negative numbers and a target integer k,
write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k,
that is, sums up to n*k where n is also an integer.

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
Note:
The length of the array won't exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.

 */


package com.zmc;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {0,0};
        System.out.print(checkSubarraySum(nums, 0));
    }

    // time complexity O(N ^ 2), space complexity O(N)
    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;

        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) sums[i] = sums[i - 1] + nums[i];

        for (int i = 0; i < nums.length; ++i) {
            if (sums[i] == k && i > 0) return true;
            if (k != 0 && sums[i] % k == 0 && i > 0) return true;
            for (int j = i + 1; j < nums.length; ++j) {
                if (((sums[j] - sums[i]) == k)) {
                    if (j > i + 1) return true;
                }

                if (k != 0 && (sums[j] - sums[i]) % k == 0) {
                    if (j > i + 1) return true;
                }
            }
        }

        return false;
    }

    // time O(N) space O(N)
    public static boolean checkSubarraySum2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (k != 0) sum %= k;
            Integer pre = map.get(sum);
            if (pre != null) {
                if (i - pre > 1) return true;
            }
            else map.put(sum, i);
        }

        return false;
    }
}




