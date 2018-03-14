
/*

https://leetcode.com/problems/power-of-two/description/

Given an integer, write a function to determine if it is a power of two.

 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(isPowerOfTwo(-2147483648));
        System.out.print(Integer.MIN_VALUE);
    }

    public static boolean isPowerOfTwo(int n) {
        return ((n & (n - 1)) == 0) && n >= 0;
    }
}
