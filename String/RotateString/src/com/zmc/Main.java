package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(rotateString("abcde", "bcdea"));
    }

    public static boolean rotateString(String A, String B) {
        if (A == null || B == null) return false;
        if (A.length() != B.length()) return false;

        int i = 0, j = 0;
        while (i < B.length()) {
            char first = A.charAt(0);
            if (first == B.charAt(i)) {
                j = i < B.length() - 1? i + 1: 0;
                while (j != i) {
                    int offset = j > i? -i: A.length() - i;
                    if (A.charAt(j + offset) != B.charAt(j)) break;

                    if (j == B.length() - 1) j = 0;
                    else j ++;
                }
                if (i == j) return true;
            }
            i ++;
        }

        return i == j;
    }
}
