package com.zmc;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here

    }

    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) return 0;

        Set<String> set = new HashSet<>();

        String[] ss = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        for (String s: words) {
            String tmp = "";
            for (char c: s.toCharArray()) {
                tmp += ss[c - 'a'];
            }
            set.add(tmp);
        }

        return set.size();
    }
}
