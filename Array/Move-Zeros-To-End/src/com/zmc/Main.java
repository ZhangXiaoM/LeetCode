package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {0,1,0,4,5,0,7,9};
        moveZeroToEnd(nums);
    }
    // move all zero to end of array, time complexity O(N)
    static int[] moveZeroToEnd(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        int i = 0, j = 1;
        while (i < nums.length && j < nums.length) {
            while (i < nums.length && nums[i] != 0) i++;
            while (j < nums.length && nums[j] == 0) j++;

            if (i < nums.length && j < nums.length) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return nums;
    }
}
