
/*

https://leetcode.com/problems/self-dividing-numbers/description/

A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0,
and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible
self dividing number, including the bounds if possible.

Example 1:
Input:
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
Note:

The boundaries of each input argument are 1 <= left <= right <= 10000.
 */

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1,22));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            if (isSelfDivdingNmber(i)) list.add(i);
        }

        return list;
    }

    public static boolean isSelfDivdingNmber(int n) {

        boolean res = true;
        int temp = n;

        while (temp != 0) {
            int x = temp % 10;
            if (x != 0) {
                res &= (n % x == 0);
            } else {
                return false;
            }
            temp /= 10;
        }

        return res;
    }
}
