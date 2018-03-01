
/*

https://leetcode.com/problems/reverse-words-in-a-string/description/

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.

 */

package com.zmc;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	    System.out.print(reverseWords2(" The  sky is blue"));
    }

    // solution with stack and library function:split()
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;

        String[] ss = s.split(" ");
        Stack<String> stack = new Stack<>();
        for (String temp : ss) {
            if (temp.length() == 0 || temp.equals(" ")) {
                continue;
            }
            stack.push(temp);
        }

        String res = "";
        while (!stack.isEmpty()) {
            res += stack.pop();
            res += " ";
        }

        if (res.equals(" ")) {
            return "";
        } else {
            return res.substring(0, res.length() > 0? res.length() - 1 : 0);
        }
    }


    // another solution with no library function
    public static String reverseWords2(String s) {
        if (s == null || s.length() == 0) return s;

        char[] cs = s.toCharArray();
        int i = 0, j = 0;
        while (i < s.length() && cs[i] == ' ') i ++;

        cs = reverseWord(cs, i, s.length());
        while (i < s.length()) {
            while (j < s.length() && cs[j] != ' ') j ++;
            reverseWord(cs, i, j);
            while (j < s.length() && cs[j] == ' ') j ++;
            i = j;
        }

        return cleanSpaces(cs, s.length());
    }

    static char[] reverseWord(char[] cs, int i, int j) {
        for (int idx = i; idx < (i+j)/2; idx ++) {
            char temp = cs[idx];
            cs[idx] = cs[j - 1 + i - idx];
            cs[j - 1 + i - idx] = temp;
        }
        return cs;
    }

    static String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }
}
