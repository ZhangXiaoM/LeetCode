
/*

https://leetcode.com/problems/majority-element/description/

Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1,2,1,1,3,1};
        System.out.print(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {

        if (nums == null || nums.length == 0) return -1;

        int times = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            if (times == 0) {
                res = nums[i];
                times = 1;
            } else if (res == nums[i])
                times ++;
            else
                times --;
        }

        return res;
    }
}
