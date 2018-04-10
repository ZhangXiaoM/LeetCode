
/*
Given an array of integers and an integer k,
you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */


package com.zmc;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1};
        System.out.print(subarraySum2(nums, 1));
    }

    // best time complexity O(N), space complexity O(n)
    // if the hash table has hash collision, the worst time complexity is O(N ^ 2)
    public static int subarraySum(int[] nums, int k) {

        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, cnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                cnt += map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return cnt;
    }

    // time complexity O(N ^ 2), space complexity O(n)
    public static int subarraySum2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0, cnt = 0;
        int[] sums = new int[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            sums[i] = sum;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (sums[i] == k) cnt ++;
            for (int j = i + 1; j < nums.length; ++j) {
                if (sums[j] - sums[i] == k) cnt ++;
            }
        }

        return cnt;
    }
}
