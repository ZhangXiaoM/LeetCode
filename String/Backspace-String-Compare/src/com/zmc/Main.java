/**
 *
 * https://leetcode.com/problems/backspace-string-compare/description/
 *
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 *
 * Follow up:
 *
 * Can you solve it in O(N) time and O(1) space?
 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(backspaceCompare("a#c", "#b"));
    }

    public static boolean backspaceCompare(String S, String T) {

        StringBuffer stmp = new StringBuffer(), ttmp = new StringBuffer();
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '#') {
                if (stmp.length() != 0) {
                    stmp.deleteCharAt(stmp.length() - 1);
                }
            } else {
                stmp.append(S.charAt(i));
            }
        }

        for (int i = 0; i < T.length(); ++i) {
            if (T.charAt(i) == '#') {
                if (ttmp.length() != 0) {
                    ttmp.deleteCharAt(ttmp.length() - 1);
                }
            } else {
                ttmp.append(T.charAt(i));
            }
        }

        return stmp.toString().equals(ttmp.toString());
    }
}
