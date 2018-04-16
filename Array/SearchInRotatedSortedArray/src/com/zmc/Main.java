
/*

https://leetcode.com/problems/search-in-rotated-sorted-array/description/

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

 */

package com.zmc;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1};
        System.out.print(search(nums, 1));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int rotatedIdx = findRotatedIdx(nums);
        int idx = -1;
        if (rotatedIdx >= 0) {
            if (target >= nums[0]) {
                idx = Arrays.binarySearch(nums, 0, rotatedIdx > 0? rotatedIdx : nums.length, target);
            } else {
                idx = Arrays.binarySearch(nums, rotatedIdx, nums.length, target);
            }
        }
        return idx < 0? -1 : idx;
    }

    static int findRotatedIdx(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;

        int left = 0, right = nums.length - 1, len = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
