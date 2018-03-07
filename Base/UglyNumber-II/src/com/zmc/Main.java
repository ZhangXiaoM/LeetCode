
/*

https://leetcode.com/problems/ugly-number-ii/description/

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690
 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.print(nthUglyNumber(8));
    }

    //time complexity O(N) space complexity O(N)
    public static int nthUglyNumber(int n) {

        if (n <= 0) return 0;
        int[] nums = new int[n];
        nums[0] = 1;
        int nextIndex = 1;

        int i = 0, j = 0, k = 0;

        while (nextIndex < n) {
            int min = Math.min(nums[i] * 2, nums[j] * 3);
            min = Math.min(min, nums[k] * 5);
            nums[nextIndex] = min;

            while (nums[i] * 2 <= nums[nextIndex]) ++i;
            while (nums[j] * 3 <= nums[nextIndex]) ++j;
            while (nums[k] * 5 <= nums[nextIndex]) ++k;

            ++nextIndex;
        }

        return nums[nextIndex - 1];
    }
}
