
/*

X is a good number if after rotating each digit individually by 180 degrees,
we get a valid number that is different from X.
Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation.
0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other,
and the rest of the numbers do not rotate to any other number and become invalid.

Now given a positive number N, how many numbers X from 1 to N are good?

Example:
Input: 10
Output: 4
Explanation:
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
Note:

N  will be in range [1, 10000].

 */


package com.zmc;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(rotatedDigits(10));
    }

    // time complexity about O(N), because `N will be in range [1, 10000];
    // space complexity O(1)

    public static int rotatedDigits(int N) {

        int sum = 0;
        for (int i = 2; i <= N; ++i) {
            if (isGood(i)) sum ++;
        }

        return sum;
    }

    static boolean isGood(int n) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('2', '5');
        map.put('5', '2');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        String original = String.valueOf(n);
        String des = "";
        for (char c: original.toCharArray()) {
            if (map.containsKey(c)) {
                des += map.get(c);
            } else {
                return false;
            }
        }

        return !des.equals(original);
    }
}
