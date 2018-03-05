
/*

https://leetcode.com/problems/base-7/description/

Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].

 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(convertToBase7(-100));
    }

    public static String convertToBase7(int num) {

        if (num == 0) return "0";

        String res = "";
        int val = num;
        while (val != 0) {
            int temp = Math.abs(val % 7);
            res = String.valueOf(temp) + res;
            val /= 7;
        }
        res = num < 0? "-" + res : "" + res;

        return res;
    }
}
