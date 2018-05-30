package com.zmc;

/*

https://leetcode.com/problems/permutation-in-string/description/

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
In other words, one of the first string's permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].


 */

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(checkInclusion("abc", "babc"));
    }

    // space O(1) time O(n)
    /* slide window, i is left of window, j is right of window, if character of s2
     * is in s1, make j go right, if substring of s2 match substring of s1 note not
     * s1, make i go right, just j - i + 1 == s1.length we get true.
     */

    public static boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        for (int c: s1.toCharArray()) {
            map[c - 'a'] ++;
        }

        int i = 0, j = 0;
        while (j < s2.length()) {
            char c = s2.charAt(j);
            if (map[c - 'a'] > 0) {
                map[c - 'a'] --;
                if (j - i + 1 == s1.length()) return true;
            } else {
                // match failed, recover the map.
                if (i < j) {
                    map[s2.charAt(i) - 'a'] ++;
                    j --;
                }
                i ++;
            }
            j ++;
        }
        return false;
    }
}
