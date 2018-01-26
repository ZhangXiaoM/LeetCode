
/*

https://leetcode.com/problems/keyboard-row/description/

Given a List of words, return the words that can be typed using
letters of alphabet on only one row's of American keyboard like the image below.


Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
Note:
You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.

判断字符串数组中的字符串是否是由美式键盘上某一排字母组成，返回符合条件的字符串。

注：
  * 键盘上的字母可以使用多次
  * 假定输入字符串只包含字母

 */


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String[] s = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(findWords(s));
    }

    // violence solution with time complexity O(M * N)

    public static String[] findWords(String[] words) {
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";

        ArrayList<String> list = new ArrayList<>();

        for (String s : words) {
            s = s.toLowerCase();
            if (s.length() == 0 || s == null) break;
            String c = String.valueOf(s.charAt(0));
            if (s1.contains(c)) {
                if (isBelong(s1, s)) list.add(s);
            } else if (s2.contains(c)) {
                if (isBelong(s2,s)) list.add(s);
            } else {
                if (isBelong(s3,s)) list.add(s);
            }
        }

        String[] res = new String[list.size()];

        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static boolean isBelong(String s1, String s) {

        for (char c : s.toCharArray()) {
            String c0 = String.valueOf(c);
            if (!(s1.contains(c0)))
                return false;
        }

        return true;
    }
}
