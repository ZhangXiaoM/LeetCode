
/*
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.
 */

public class Main {

    public static void main(String[] args) {
        int cnt = countSubstrings("abc");
        System.out.println(cnt);
    }

    /*
        O(N^2) solution
     */
    public static int countSubstrings(String s) {

        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            cnt += countOfPalindromicAtIndex(s, i, i);
            cnt += countOfPalindromicAtIndex(s, i, i + 1);
        }
        return cnt;
    }

    public static int countOfPalindromicAtIndex(String s, int i, int j) {

        int count = 0;
        for (;i >= 0 && j < s.length(); --i, ++j) {
            if (s.charAt(i) == s.charAt(j)) {
                count ++;
            } else {
                break;
            }
        }
        return count;
    }
}
