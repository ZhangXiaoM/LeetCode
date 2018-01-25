
/*

https://leetcode.com/problems/partition-labels/description/

A string S of lowercase letters is given.
We want to partition this string into as many parts as possible so that each letter appears in at most one part,
and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect,
because it splits S into less parts.

Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.

 */

import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(S));
    }

    public static List<Integer> partitionLabels(String S) {

        if (S == null || S.length() == 0) return null;

        List<Integer> list = new ArrayList();

        // 存储每个字符的最后一次出现的index
        int[] table = new int[26];

        for (int i = 0; i < S.length(); ++i) {
            table[S.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int last = 0;

        for (int i = 0; i < S.length(); ++i) {
            last = table[S.charAt(i) - 'a'] > last? table[S.charAt(i) - 'a'] : last;

            if (i == last) {
                list.add(last - start + 1);

                start = last + 1;
            }
        }

        return list;
    }
}
