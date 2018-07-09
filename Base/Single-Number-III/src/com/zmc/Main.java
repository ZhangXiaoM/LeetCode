
/*

https://leetcode.com/problems/single-number-iii/description/

Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity.
Could you implement it using only constant space complexity?
 */


package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,2,1,3,2,5};
        singleNumber(nums);
    }

    public static int[] singleNumber(int[] nums) {

        int[] res = new int[2];
        if (nums == null || nums.length == 0) return res;

        int xor = 0;
        for (int num: nums) {
            xor ^= num;
        }
        // get rightmost set bit
        xor &= -xor;

        for (int num: nums) {
            if ((xor & num) != 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
