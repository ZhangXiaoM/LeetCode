
/*

https://leetcode.com/problems/3sum/description/

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */


package com.zmc;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.print(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return null;

        if (nums.length == 0) return res;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int idx = Arrays.binarySearch(nums, j + 1, nums.length, -(nums[i] + nums[j]));
                if (idx > j) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[idx]);
                    res.add(l);
                }
            }
        }
        return res;
    }
}
