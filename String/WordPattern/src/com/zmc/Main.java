
/*

https://leetcode.com/problems/word-pattern/description/

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */



package com.zmc;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String pattern = "abcd";
        String str = "dog cat fish pig";
        System.out.print(wordPattern(pattern, str));
    }

    public static boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null) return true;
        if (pattern == null || str == null) return false;

        Map<Character, String> map = new HashMap<>();
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) return false;

        for (int i = 0; i < pattern.length(); ++i) {
            char a = pattern.charAt(i);
            String cur = map.get(a);
            if (cur == null) {
                if (map.containsValue(strs[i])) return false;
                else map.put(a, strs[i]);
            } else {
                if (!cur.equals(strs[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
