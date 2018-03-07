
/*

https://leetcode.com/problems/happy-number/description/

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer,
replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

 */

package com.zmc;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(isHappy(2));
    }

    public static boolean isHappy(int n) {

        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            int temp = n, sum = 0;
            while (temp != 0) {
                int remian = temp % 10;
                sum += remian * remian;
                temp /= 10;
            }

            if (list.contains(sum)) return false;

            if (sum == 1) return true;
            else list.add(sum);
            n = sum;
        }

        return true;
    }
}
