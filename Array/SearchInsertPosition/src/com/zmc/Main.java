
/*

https://leetcode.com/problems/search-insert-position/description/

Given a sorted array and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 1:

Input: [1,3,5,6], 0
Output: 0

 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,3,5,6};
        System.out.print(searchInsert(nums, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target < nums[mid]) {
                hi = mid - 1;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return lo;
    }
}
