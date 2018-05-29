
/*

https://leetcode.com/problems/palindrome-number/description/

Determine whether an integer is a palindrome.
An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?
 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int back = 0;
        int temp = x;
        while (temp != 0) {
            int m = temp % 10;
            back = back * 10 + m;
            temp /= 10;
        }
        return back == x;
    }

}
