
/*

https://leetcode.com/problems/rotate-array/description/

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

Hint:
Could you do it in-place with O(1) extra space?

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.
 */


package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,2,3,4,5,6,7};
        rotate2(nums, 2);

    }
    // violence solution
    // time complexity O(N ^ 2) and time limit exceeded
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return;
        k %= nums.length;
        for (int i = 0; i < nums.length - k; ++i) {
            for (int j = 0; j < nums.length - 1; ++j) {
                int temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
            }
        }
    }

    // time complexity O(N)
    public static void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return;
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    static void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}
