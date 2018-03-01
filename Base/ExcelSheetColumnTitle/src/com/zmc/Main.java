
/*

https://leetcode.com/problems/excel-sheet-column-title/description/

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB

 */


package com.zmc;

public class Main {

    public static void main(String[] args) {
	    System.out.print(convertToTitle(1));
    }

    public static String convertToTitle(int n) {
        if (n <= 0) return null;
        String res = "";
        while (n != 0) {
            char temp;
            if (n % 26 == 0) {
                temp = 'Z';
                n = n / 26 - 1;
            } else {
                temp = (char)('A' - 1 + n % 26);
                n = n / 26;
            }
            res += temp;

        }

        char[] cs = res.toCharArray();
        for (int i = 0; i < cs.length / 2; ++i) {
            char temp = cs[i];
            cs[i] = cs[cs.length - i - 1];
            cs[cs.length - i - 1] = temp;
        }

        return new String(cs);
    }
}
