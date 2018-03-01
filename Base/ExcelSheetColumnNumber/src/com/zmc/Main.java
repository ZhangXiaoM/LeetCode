
/*

https://leetcode.com/problems/excel-sheet-column-number/description/

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28

 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	    System.out.print(titleToNumber("AZ"));
    }

    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;

        int res = 0, n = s.length();
        for (int i = n - 1; i >= 0; --i) {
            res += (s.charAt(i) - 'A' + 1) * Math.pow(26, n - i - 1);
        }
        return res;
    }
}
