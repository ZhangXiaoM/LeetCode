package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(kmp("abcabx", "abx"));
    }

    static int kmp(String s, String pa) {
        int i = 0, j = 0;
        int[] pmt = getPatialMatchedTable(pa);
        while (i < s.length() && j < pa.length()) {
            if (j == -1 || s.charAt(i) == pa.charAt(j)) {
                ++ i;
                ++ j;
            } else {
                j = pmt[j];
            }
        }

        return j == pa.length()? i - j : -1;
    }


    static int[] getPatialMatchedTable(String s) {
        if (s == null || s.length() == 0) return null;

        int[] pmt = new int[s.length()];
        pmt[0] = -1;
        int i = 1, j = -1;
        while (i < s.length() - 1) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                ++i;
                ++j;
                pmt[i] = j;
            } else {
                j = pmt[j];
            }
        }
        return pmt;
    }
}
