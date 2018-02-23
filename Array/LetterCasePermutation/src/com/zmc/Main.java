
/*

https://leetcode.com/problems/letter-case-permutation/description/

Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length at most 12.
S will consist only of letters or digits.


 */


package com.zmc;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.print(letterCasePermutation("a1b2"));
    }

    public static List<String> letterCasePermutation(String S) {

        List<String> res = new ArrayList<>();
        res.add(S);

        int currentIndex = 0;
        while (currentIndex < S.length()) {
            if (S.charAt(currentIndex) >= '0' && S.charAt(currentIndex) <= '9') {
                currentIndex ++;
                continue;
            }
            int size = res.size();
            for (int j = 0; j < size; ++j) {
                res.add(revertCaseAtIndex(currentIndex, res.get(j)));
            }
            currentIndex ++;
        }

        return res;
    }

    static String revertCaseAtIndex(int i, String S) {
        char c = S.charAt(i);
        int diff = 'A' - 'a';
        if (c >= 'a' && c <= 'z') {
            c += diff;
        } else {
            c -= diff;
        }

        return S.substring(0, i) + c + S.substring(i + 1, S.length());
    }
}
