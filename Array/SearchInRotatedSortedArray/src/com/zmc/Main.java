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
        if (idx < 0) return -1;
        else return idx;
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
