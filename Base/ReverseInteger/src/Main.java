
/*

https://leetcode.com/problems/reverse-integer/description/

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.

For the purpose of this problem,
assume that your function returns 0 when the reversed integer overflows.
 */

public class Main {

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        int bits = 0;
        int t = x;
        while (t != 0) {
            bits ++;
            t /= 10;
        }

        long res = 0;

        for (int i = 0; i < bits; ++i) {
            int temp = x % 10;
            res += temp * Math.pow(10, bits - i - 1);
            x /= 10;
        }

        return (res <= Integer.MAX_VALUE && res >= Integer.MIN_VALUE)? (int)res : 0;
    }
}
