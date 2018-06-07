
/*

https://leetcode.com/problems/contains-duplicate-ii/description/#

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false

 */


package com.zmc;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,2,3,1,2,3};
        System.out.print(containsNearbyDuplicate(nums, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || k < 0) return false;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            Integer val = map.get(nums[i]);
            map.put(nums[i], i);
            if (val != null) {
                if (k >= Math.abs(i - val)) return true;
            }
        }

        return false;
    }
}
