
/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

 */

import java.lang.reflect.Array;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] ints = {3,2,4,4,7,20,7};
        System.out.println(twoSum2(ints, 8));
    }

    // time complexity O(N^2)
    public static int[] twoSum(int[] nums, int target) {

        int[] re = {0,0};
        if (nums.length <= 0) return re;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] == target - nums[i]) {
                    int[] result = {i,j};
                    return result;
                }
            }
        }

        return re;
    }

    // time complexity O(N*lgN)
    public static int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; ++i) {
            int j = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
            if (j >= 0) {
                int[] res = {i + 1, j + 1};
                return res;
            }
        }

        return new int[0];
    }
}
