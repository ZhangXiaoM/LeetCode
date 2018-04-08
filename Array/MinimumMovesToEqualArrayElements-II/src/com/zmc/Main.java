
/*

https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/

Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]


using partition function find the middle bigger number of nums.

then, make all number move to the middle, the number of this moves is the smallest.

 */


package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,1,2};
        System.out.print(minMoves2(nums));
    }

    public static int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int mid = findMiddle(nums);
        int res = 0;

        for (int x: nums) {
            res += Math.abs(x - mid);
        }
        return res;
    }

    static int findMiddle(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int mid = (nums.length - 1) / 2;
        int beg = 0, end = nums.length - 1;
        int index = partition(nums, beg, end);
        while (index != mid) {
            if (index < mid) {
                beg = index + 1;
                index = partition(nums, beg, end);
            } else {
                end = index - 1;
                index = partition(nums, beg, end);
            }
        }
        return nums[index];
    }

    static int partition(int[] nums, int beg, int end) {
        int pivot = nums[end];
        int index = beg;
        for (int i = beg; i <= end; ++i) {
            if (nums[i] < pivot) {
                swap(nums, index, i);
                index ++;
            }
        }
        swap(nums, index, end);
        return index;
    }

    static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] += nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] -= nums[j];
        }
    }

}
