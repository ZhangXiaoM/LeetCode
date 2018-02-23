
/*

https://leetcode.com/problems/find-peak-element/description/

A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

Note:
Your solution should be in logarithmic complexity.

 */


package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int findPeakElement(int[] nums) {
        return binaryFind(nums, 0, nums.length - 1);
    }

    int binaryFind(int[] nums, int start, int end) {

        if (start == end) {
            return start;
        } else if (start + 1 == end) {
            if (nums[start] > nums[end]) return start;
            return end;
        } else {
            int m = (start + end) / 2;
            if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1]) {
                return m;
            } else if (nums[m] > nums[m - 1] && nums[m] < nums[m + 1]) {
                return binaryFind(nums, m + 1, end);
            } else {
                return binaryFind(nums, start, m - 1);
            }
        }
    }
}
