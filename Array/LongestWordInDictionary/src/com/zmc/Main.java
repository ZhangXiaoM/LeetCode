
/*

https://leetcode.com/problems/longest-word-in-dictionary/description/

Given a list of strings words representing an English Dictionary,
find the longest word in words that can be built one character at a time by other words in words.
If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:
Input:
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation:
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input:
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation:
Both "apply" and "apple" can be built from other words in the dictionary.
However, "apple" is lexicographically smaller than "apply".
Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].

 */


package com.zmc;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] words = {"ts","e","x","pbhj","opto","xhigy","erikz","pbh","opt","erikzb","eri","erik","xlye","xhig","optoj","optoje","xly","pb","xhi","x","o"};
        System.out.print(longestWord(words));
    }

    // time complexity O(N^2) space complexity O(N)
    public static String longestWord(String[] words) {
        int max = 0;
        String res = "";
        HashSet<String> set = new HashSet<>();
        // O(N^2)
        for (String t: words) {
            if (t.length() == 1) {
                set.add(t);
                dfs(words, t, set);
            }
        }
        if (set.size() == 0) return "";
        // O(N)
        for (String t: set) {
            if (max < t.length()) {
                max = t.length();
                res = t;
            } else if (max == t.length()) {
                int c = res.compareTo(t);
                if (c > 0) {
                    res = t;
                }
            }
        }

        return max == 0? "" : res;
    }

    static void dfs(String[] words, String word, HashSet<String> set) {
        for (String t: words) {
            if (t.startsWith(word) && t.length() == word.length() + 1) {
                set.add(t);
                dfs(words, t, set);
            }
        }
    }
}
