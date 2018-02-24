
/*

https://leetcode.com/problems/number-complement/description/

Given a positive integer, output its complement number.
The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	    System.out.print(findComplement(2147483647));
    }

    public static int findComplement(int num) {

        String bitsStr = Integer.toBinaryString(num);
        /*
            Note:
            The max value of 32-bits signed integer
         */
        long help = (long)Math.pow(2, bitsStr.length())  - 1;
        return ((int)help - num);
    }
}
