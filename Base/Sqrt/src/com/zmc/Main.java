
/*

https://leetcode.com/problems/sqrtx/description/

Implement int sqrt(int x).

Compute and return the square root of x.

x is guaranteed to be a non-negative integer.


Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842...,
and since we want to return an integer, the decimal part will be truncated.
 */



package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(mySqrt(8));
    }

    public static int mySqrt(int x) {
        if (x <= 0) return 0;

        int a = 1, b = x;
        while (true) {
            int mid = a + (b - a)/2;

            if (mid > x/mid) {
                b = mid - 1;
            } else {
                if ((mid + 1) > x/(mid + 1)) {
                    return mid;
                }
                a = mid + 1;
            }
        }
    }
}
