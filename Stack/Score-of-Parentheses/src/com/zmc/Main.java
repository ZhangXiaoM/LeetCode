
/*

https://leetcode.com/problems/score-of-parentheses/description/

Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.


Example 1:

Input: "()"
Output: 1
Example 2:

Input: "(())"
Output: 2
Example 3:

Input: "()()"
Output: 2
Example 4:

Input: "(()(()))"
Output: 6


Note:

S is a balanced parentheses string, containing only ( and ).
2 <= S.length <= 50
 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int scoreOfParentheses(String S) {
        if (S.length() < 2) return 0;

        int cnt = 0, res = 0;
        for (int i = 0; i < S.length(); ++i) {
            char tmp = S.charAt(i);
            if (tmp == '(') cnt ++;
            else cnt --;

            if (tmp == '(' && S.charAt(i + 1) == ')')
                res += 1 << (cnt - 1);
        }
        return res;
    }
}
