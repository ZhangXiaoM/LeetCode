package com.zmc;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.print(letterCasePermutation("a1b2"));
	// write your code here
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
