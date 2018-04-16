
/*

https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here

    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }

        return nums[left];
    }
}
