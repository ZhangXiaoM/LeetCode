/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
 */

public class Main {

    public static void main(String[] args) {

        String s = "";
        System.out.println(longestPalindrome(s));
    }

    // my worst solution with time complexity O(N^3),but submission with time exceeded
    public static String longestPalindrome(String s) {
        if (s == null) return null;

        int max = 0;
        String res = "";

        if (isPalindrome(s, 0, s.length() - 1)) return s;

        for (int i = 0; i < s.length(); i ++) {
            for (int j = s.length() - 1; j >= i; j --) {
                if (isPalindrome(s, i, j)) {
                    if (max < j - i + 1) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }

        return res;
    }

    static boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }


    // LeetCode user solution time complexity O(N^2)

    public static String longestPalindrome2(String s) {
        String max = "";
        for (int i = 0; i < s.length(); ++i) {
            String s1 = extend(s, i, i);
            String s2 = extend(s, i, i + 1);
            if (max.length() < s1.length()) max = s1;
            if (max.length() < s2.length()) max = s2;
        }

        return max;
    }

    public  static String extend(String s, int i, int j) {

        for (; i >= 0 && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) break;
        }
        return s.substring(i + 1, j);
    }
}
