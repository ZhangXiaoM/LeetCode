
/*

https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/

Given two integers L and R, find the count of numbers in the range [L, R] (inclusive)
having a prime number of set bits in their binary representation.

(Recall that the number of set bits an integer has is the number of 1s present when written in binary.
For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)

Example 1:

Input: L = 6, R = 10
Output: 4
Explanation:
6 -> 110 (2 set bits, 2 is prime)
7 -> 111 (3 set bits, 3 is prime)
9 -> 1001 (2 set bits , 2 is prime)
10->1010 (2 set bits , 2 is prime)
Example 2:

Input: L = 10, R = 15
Output: 5
Explanation:
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)
Note:

L, R will be integers L <= R in the range [1, 10^6].
R - L will be at most 10000.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println(countPrimeSetBits(842,888));
    }

    // time complexity O(R), space complexity O(R)

    public static int countPrimeSetBits(int L, int R) {
        if (L > R || L < 0) return 0;

        int[] re = new int[R + 1];
        for (int i = 0; i <= R; ++i) {
            re[i] = re[i >> 1] + (i & 1);
        }

        int res = 0;
        for (int i = L; i <= R; ++i) {
            if (isPrimeNumber(re[i])) res ++;
        }

        return res;
    }

    public static boolean isPrimeNumber(int n) {
        if (n == 0 || n == 1) return false;
        if (n == 2) return true;

        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
