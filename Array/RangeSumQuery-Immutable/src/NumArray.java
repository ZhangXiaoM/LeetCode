
/*

https://leetcode.com/problems/range-sum-query-immutable/description/

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 */

public class NumArray {

    public int[] _nums;

    public NumArray(int[] nums) {
        _nums = nums;
    }

    public int sumRange(int i, int j) {

        int sum = 0;
        if (i >= 0 && j < _nums.length) {
            for (int k = i; k <= j; ++k) {
                sum += _nums[k];
            }
        }

        return sum;
    }
}
