
/*

https://leetcode.com/problems/most-common-word/description/

Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.
Words in the paragraph are not case sensitive.  The answer is in lowercase.

Example:
Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.
 */

package com.zmc;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] ss = {"hit"};
        System.out.print(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", ss));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || banned == null) return "";

        Character[] help = {'!','?',',',';','.',' ','\''};
        Set<Character> set = new HashSet<>(Arrays.asList(help));

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < paragraph.length(); ++i) {
            if (set.contains(paragraph.charAt(i))) {
                paragraph = paragraph.replace(paragraph.charAt(i), ' ');
            }
        }

        String[] ss = paragraph.split(" ");
        for (String s: ss) {
            if (s.length() > 0)
                map.put(s.toLowerCase(), map.getOrDefault(s.toLowerCase(), 0) + 1);
        }

        for (String s: banned) {
            map.remove(s);
        }
        int max = 0;
        String res = "";
        for (String s: map.keySet()) {
            if (max < map.get(s)) {
                res = s;
                max = map.get(s);
            }
        }
        return res;
    }
}
