
/*

https://leetcode.com/problems/power-of-four/description/

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

explanation:

Power of four in 2-bits:

1
100
10000
1000000
100000000

the odd bit is 1.
0x55555555:
01010101010101010101010101010101

`(num & 0x55555555) != 0` can guarantee the odd bit is 1.

 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(isPowerOfFour(64));
    }

    public static boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
