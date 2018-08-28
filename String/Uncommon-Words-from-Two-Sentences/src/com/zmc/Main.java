/**
 *
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
 *
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 *
 * Return a list of all uncommon words.
 *
 * You may return the list in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 *
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 *
 *
 * Note:
 *
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 */

package com.zmc;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        uncommonFromSentences("s z z z s", "s z ejt");
    }

    public static String[] uncommonFromSentences(String A, String B) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> sb = new HashSet<>();

        String[] arrA = A.split(" ");
        String[] arrB = B.split(" ");

        for (String s: arrA) {
            sb.add(s);
            if (!set.add(s)) sb.remove(s);
        }

        for (String s: arrB) {
            sb.add(s);
            if (!set.add(s)) sb.remove(s);
        }

        return sb.toArray(new String[sb.size()]);
    }
}
