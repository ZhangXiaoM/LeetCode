
/**
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.print(1);
    }

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int[] help = new int[3];
        for (int i: nums) {
            help[i] ++;
        }

        int k = 0;
        for (int i = 0; i < help.length; ++i) {
            for (int j = 0; j < help[i]; ++j) {
                nums[k ++] = i;
            }
        }
    }
}
