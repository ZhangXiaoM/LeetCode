
/*

https://leetcode.com/problems/is-subsequence/description/

Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t.
t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original
string by deleting some (can be none) of the characters without disturbing the
relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.
 */

public class Main {

    public static void main(String[] args) {
        String s = "aa";
        String t = "ab";
        System.out.println(isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {

        if (s.length() > t.length()) return false;
        if (s.length() == t.length()) return s.equals(t);

        int i = 0, j = 0;
        while (i < s.length()) {
            while (j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    j ++;
                    break;
                }
                j ++;
            }
            i ++;
            if (j == t.length()) break;
        }

        return i == s.length();
    }
}
