
/*

https://leetcode.com/problems/repeated-substring-pattern/description/

Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

 */


package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(repeatedSubstringPattern("abcabcabcabc"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 1) return false;

        int idx = 1;
        char c = s.charAt(0);
        while (idx < s.length()) {
            if (s.charAt(idx) == c) {
                int len = idx;
                if (s.length() % len == 0) {
                    int cnt = s.length() / len, j = 0;
                    while (j < cnt) {
                        int start = j * len, end = start + len;
                        String repeat = s.substring(0, idx);
                        if (!repeat.equals(s.substring(start, end))) {
                            break;
                        }
                        j ++;
                    }
                    if (j == cnt) return true;
                }
            }
            idx ++;
        }
        return false;
    }
}
