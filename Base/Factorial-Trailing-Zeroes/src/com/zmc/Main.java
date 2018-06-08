
/*

https://leetcode.com/problems/factorial-trailing-zeroes/description/

Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Note: Your solution should be in logarithmic time complexity.

 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(trailingZeroes(11));
    }

    public static int trailingZeroes(int n) {
        int temp = n, res = 0;

        while (temp > 4) {
            res += temp /= 5;
        }
        return res;
    }
}
