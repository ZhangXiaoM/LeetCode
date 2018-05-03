
/*
You are given a license key represented as a string S which consists only alphanumeric character and dashes.
The string is separated into N+1 groups by N dashes.

Given a number K, we would want to reformat the strings such that each group contains exactly K characters,
except for the first group which could be shorter than K,
but still must contain at least one character.
 Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.

Given a non-empty string S and a number K, format the string according to the rules described above.

Example 1:
Input: S = "5F3Z-2e-9-w", K = 4

Output: "5F3Z-2E9W"

Explanation: The string S has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.
Example 2:
Input: S = "2-5g-3-J", K = 2

Output: "2-5G-3J"

Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
Note:
The length of string S will not exceed 12,000, and K is a positive integer.
String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
String S is non-empty.

 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = licenseKeyFormatting("22", 2);
        System.out.print(s);
    }

    /*
     * Note:
     * 1. The length of string S will not exceed 12,000, and K is a positive integer.
     * 2. String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
     * 3. String S is non-empty.
     *
     */

    public static String licenseKeyFormatting(String S, int K) {

        StringBuilder sb = new StringBuilder();

        if (K == 0) return "";
        int cnt = 0;
        for (int i = S.length() - 1; i >= 0; --i) {
            char c = S.charAt(i);
            if (Character.isAlphabetic(c)) {
                sb.append(Character.toUpperCase(c));
                cnt ++;
            } else if (Character.isDigit(c)) {
                sb.append(c);
                cnt ++;
            } else {
                continue;
            }

            if (cnt == K) {
                sb.append("-");
                cnt = 0;
            }
        }

        if (sb.length() - 1 >= 0 && sb.charAt(sb.length() - 1) == '-')
            sb.deleteCharAt(sb.length() - 1);

        return sb.reverse().toString();
    }
}
