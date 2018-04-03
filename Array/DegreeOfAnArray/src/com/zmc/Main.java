
/*

https://leetcode.com/problems/degree-of-an-array/description/

Given a non-empty array of non-negative integers nums,
the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
Note:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.

 */

package com.zmc;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,2,2,3,1,4,2};
        System.out.print(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            Integer times = map.get(nums[i]);
            times = times == null? 1: times + 1;
            map.put(nums[i], times);
            max = Math.max(max, times);
        }

        int min = Integer.MAX_VALUE;
        for (Integer key: map.keySet()) {
            int beg = 0, end = 0;
            int i = 0, j = nums.length - 1;
            if (map.get(key) == max) {
                while (i < nums.length) {
                    if (key == nums[i]) {
                        beg = i;
                        break;
                    }
                    i ++;
                }

                while (j >= 0) {
                    if (key == nums[j]) {
                        end = j;
                        break;
                    }
                    j --;
                }

                min = Math.min(min, end - beg + 1);
            }
        }

        return min;
    }
}
