
/*

https://leetcode.com/problems/valid-anagram/description/

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?


 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(isAnagram("aa", "bb"));
    }

    public static boolean isAnagram(String s, String t) {
        if (t.length() != s.length()) return false;
        if (t.equals(s)) return true;

        int[] help = new int[26];
        for (char c : s.toCharArray()) {
            help[c - 'a'] ++;
        }

        for (char c : t.toCharArray()) {
            help[c - 'a'] --;
        }

        boolean res = true;
        for (int i : help) {
            res = res && (i == 0);
        }

        return res;
    }
}
