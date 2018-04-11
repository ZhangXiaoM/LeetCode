package com.zmc;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {-1,-2,3,4};
        System.out.print(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) return 0;

        Arrays.sort(nums);

        int n = nums.length;

        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] *  nums[n - 2] * nums[n - 3]);
    }
}
