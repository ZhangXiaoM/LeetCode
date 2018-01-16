
/*
Given an arbitrary ransom note string and another string containing letters from all the
magazines, write a function that will return true if the ransom note can be constructed
from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 */

public class Main {

    public static void main(String[] args) {

        System.out.println(canConstruct("aa","aab"));
    }

    static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;
        // 声明一个数组存储 magazine 中出现的字符的次数
        char[] a = new char[255];
        for (char c: magazine.toCharArray()) {
            a[c]++;
        }
        // 遍历 ransomNote 每出现一个字符，将数组中对应字符的个数减1，如果字符个数为0，则匹配失败
        for (char c: ransomNote.toCharArray()) {
            if (a[c] == 0) return false;
            a[c]--;
        }

        return true;
    }
}
