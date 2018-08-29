/**
 *
 * https://leetcode.com/problems/groups-of-special-equivalent-strings/description/
 *
 * You are given an array A of strings.
 *
 * Two strings S and T are special-equivalent if after any number of moves, S == T.
 *
 * A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].
 *
 * Now, a group of special-equivalent strings from A is a non-empty subset S of A such that any string not in S is not special-equivalent with any string in S.
 *
 * Return the number of groups of special-equivalent strings from A.
 *
 *
 * Example 1:
 *
 * Input: ["a","b","c","a","c","c"]
 * Output: 3
 * Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
 *
 * Example 2:
 *
 * Input: ["aa","bb","ab","ba"]
 * Output: 4
 * Explanation: 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
 *
 * Example 3:
 *
 * Input: ["abc","acb","bac","bca","cab","cba"]
 * Output: 3
 * Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
 *
 * Example 4:
 *
 * Input: ["abcd","cdab","adcb","cbad"]
 * Output: 1
 * Explanation: 1 group ["abcd","cdab","adcb","cbad"]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 1000
 * 1 <= A[i].length <= 20
 * All A[i] have the same length.
 * All A[i] consist of only lowercase letters.
 *
 */

package com.zmc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] A = {"aa","bb","ab","ba"};
        System.out.print(numSpecialEquivGroups(A));
    }

    public static int numSpecialEquivGroups(String[] A) {
        if (A == null || A.length == 0) return 0;

        Set<String> set = new HashSet<>();

        for (String s: A) {
            String s1 = "";
            String s2 = "";

            for (int i = 0; i < s.length(); ++i) {
                if ((i & 1) == 1) {
                    s1 += s.charAt(i);
                } else {
                    s2 += s.charAt(i);
                }
            }

            char[] cs1 = s1.toCharArray();
            char[] cs2 = s2.toCharArray();
            Arrays.sort(cs1);
            Arrays.sort(cs2);
            set.add(new String(cs1) + new String(cs2));
        }
        return set.size();
    }
}
