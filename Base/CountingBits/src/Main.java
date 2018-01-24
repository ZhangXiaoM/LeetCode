
/*
    https://leetcode.com/problems/counting-bits/description/
    Given a non negative integer number num.
    For every numbers i in the range 0 ≤ i ≤ num calculate
    the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)).
But can you do it in linear time O(n) /possibly in a single pass?

Space complexity should be O(n).

Can you do it like a boss? Do it without using
any builtin function like __builtin_popcount in c++ or in any other language.
 */


public class Main {

    public static void main(String[] args) {

        System.out.println(countBits2(5));
    }

    // time complexity O(N * lgN)

    public static int[] countBits(int num) {

        int[] res = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
            int cnt = 0;
            int temp = i;
            while (temp != 0) {
                cnt ++;
                temp &= (temp - 1);
            }
            res[i] = cnt;
        }

        return res;
    }

    // time complexity O(N)

    public static int[] countBits2(int num) {

        int[] res = new int[num + 1];

        for (int i = 1; i <= num; ++i) {
            res[i] = res[i >> 1] + (i & 1);
        }

        return res;
    }
}
