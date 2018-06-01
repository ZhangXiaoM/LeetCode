
/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
 */

package com.zmc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(isIsomorphic("foo", "bar"));
    }

    public static boolean isIsomorphic(String s, String t) {

        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if (map.get(si) == null) {
                map.put(si, ti);
            } else {
                if (map.get(si) != ti) return false;
            }
        }

        for (char ti: map.values()) {
            if (!set.add(ti)) return false;
        }

        return true;
    }
}
