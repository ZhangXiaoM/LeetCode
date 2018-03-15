
/*

https://leetcode.com/problems/longest-harmonious-subsequence/description/

We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
Note: The length of the input array will not exceed 20,000.
 */


package com.zmc;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.print(findLHS(nums));
    }

    // time complexity O(N) by using map
    public static int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            Integer v = map.get(nums[i]);
            if (v == null) {
                map.put(nums[i], 1);
            } else {
                v ++;
                map.put(nums[i], v);
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            Integer pre = map.get(nums[i] - 1);
            Integer cur = map.get(nums[i]);
            Integer aft = map.get(nums[i] + 1);

            int preSum = 0;
            int aftSum = 0;

            if (pre != null) {
                preSum = pre + cur;
            }
            if (aft != null) {
                aftSum = cur + aft;
            }

            max = Math.max(max, preSum);
            max = Math.max(max, aftSum);
        }

        return max;
    }
}
