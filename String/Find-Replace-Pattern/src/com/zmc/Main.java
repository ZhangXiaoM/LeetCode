/**
 *
 * https://leetcode.com/problems/find-and-replace-pattern/description/
 *
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 *
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 *
 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
 *
 * Return a list of the words in words that match the given pattern.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 * since a and b map to the same letter.
 *
 *
 * Note:
 *
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 */

package com.zmc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        System.out.print(findAndReplacePattern(words, "abb"));
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> list = new ArrayList<>();

        for (String s: words) {
            if (isMatch(s, pattern)) list.add(s);
        }

        return list;
    }

    public static boolean isMatch(String str, String pattern) {

        if (str.length() != pattern.length()) return false;

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < str.length(); ++i) {
            Character c = str.charAt(i);
            Character pc = pattern.charAt(i);

            if (!map.containsKey(c)) {
                if (map.containsValue(pc)) return false;
                else map.put(c, pc);
            } else {
                if (map.get(c) != pc) return false;
            }
        }

        return true;
    }
}
