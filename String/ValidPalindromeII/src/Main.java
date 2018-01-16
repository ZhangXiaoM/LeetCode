/*
Given a non-empty string s, you may delete at most one character.
Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z.
The maximum length of the string is 50000.
 */


public class Main {

    public static void main(String[] args) {

        System.out.println(validPalindrome("abc"));
    }

    public static boolean validPalindrome(String s) {
        if (s == null) return false;

        int i = 0, j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                // 如果不相等，判断左指针加一后是不是回文，或者右指针减一是不是回文
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i ++;
            j --;
        }

        return true;
    }

    static boolean isPalindrome(String s, int l, int r) {

        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l ++;
            r --;
        }
        return true;
    }
}
