
/*

https://leetcode.com/problems/custom-sort-string/description/

S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously.
We want to permute the characters of T so that they match the order that S was sorted. More specifically,
if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

 */


package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(customSortString("cba", "abcmd"));
    }

    public static String customSortString(String S, String T) {
        if (S == null) return T;
        if (T == null) return null;

        String res = "";

        int[] map = new int[26];
        for (int i = 0; i < T.length(); ++i) {
            map[T.charAt(i) - 'a']++;
        }

        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            int cnt = map[c - 'a'];
            if (cnt > 0) {
                for (int j = 0; j < cnt; ++j) {
                    res += c;
                    map[c - 'a'] --;
                }
            }
        }

        for (int i = 0; i < T.length(); ++i) {
            char c = T.charAt(i);
            int cnt = map[c - 'a'];
            if (cnt > 0) {
                res += c;
            }
        }

        return res;
    }
}
