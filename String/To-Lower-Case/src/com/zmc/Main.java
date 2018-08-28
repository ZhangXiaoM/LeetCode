package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) return str;

        String res = "";

        for (char c: str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                res += (char)(c + 32);
            } else {
                res += c;
            }
        }
        return res;
    }
}
