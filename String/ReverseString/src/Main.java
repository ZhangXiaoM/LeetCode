
/*

https://leetcode.com/problems/reverse-string/description/

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

反转字符串

 */


public class Main {

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseString(s));
    }

    public static String reverseString(String s) {

        if (s == null) return null;
        if (s.length() == 0) return "";

        char[] cs = s.toCharArray();

        for (int i = 0; i < s.length() / 2; ++i) {
            char temp = cs[i];
            cs[i] = cs[s.length() - 1 - i];
            cs[s.length() - 1 - i] = temp;
        }

        return new String(cs);
    }
}
