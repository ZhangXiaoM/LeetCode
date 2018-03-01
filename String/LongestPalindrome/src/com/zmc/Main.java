
/*

https://leetcode.com/problems/longest-palindrome/description/

Given a string which consists of lowercase or uppercase letters,
find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
        System.out.print(longestPalindrome("bb"));
    }

    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;

        int evenSum = 0, N = 58;
        boolean hasOdd = false;
        int[] cs = new int[N];
        for (char c : s.toCharArray()) {
            cs[c - 'A'] ++;
        }

        for (int i = 0; i < N; ++i) {
            hasOdd = hasOdd || ((cs[i] & 0x1) == 1);
            evenSum += ((cs[i] / 2) * 2);
        }

        return hasOdd? evenSum + 1: evenSum;
    }
}
