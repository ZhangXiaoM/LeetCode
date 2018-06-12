
/*

https://leetcode.com/problems/sum-of-square-numbers/description/

Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
Input: 3
Output: False

 */


package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(judgeSquareSum(4));
    }

    public static boolean judgeSquareSum(int c) {
        if (c < 0) return false;

        int sq = (int)Math.sqrt(c);
        for (int i = 0; i <= sq; ++i) {
            double t = Math.sqrt(c - Math.pow(i, 2));
            if (t == Math.floor(t)) return true;
        }
        return false;
    }
}
