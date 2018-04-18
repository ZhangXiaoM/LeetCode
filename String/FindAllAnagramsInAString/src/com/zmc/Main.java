
/*

https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */


package com.zmc;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();

        if (p.length() > s.length()) return list;

        char[] help = new char[26];
        int pLen = p.length();

        for (char a: p.toCharArray()) {
            help[a - 'a'] ++;
        }

        int i = 0, j = i + pLen;

        while (j <= s.length()) {
            char a = s.charAt(i);
            if (help[a - 'a'] > 0) {
                if (isAnagram(s, i, j, p)) list.add(i);
            }
            i++; j++;
        }

        return list;
    }

    static boolean isAnagram(String s, int beg, int end, String p) {
        if (end - beg != p.length()) return false;

        char[] help = new char[26];
        for (char a: p.toCharArray()) {
            help[a - 'a'] ++;
        }

        for (int i = beg; i < end; ++i) {
            help[s.charAt(i) - 'a'] --;
        }

        for (int x: help) {
            if (x != 0) return false;
        }

        return true;
    }
}
