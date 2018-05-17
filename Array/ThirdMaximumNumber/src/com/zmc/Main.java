
/*

https://leetcode.com/problems/third-maximum-number/description/

Given a non-empty array of integers, return the third maximum number in this array.
If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,2,3,3};
        System.out.print(thirdMax(nums));
    }

    public static int thirdMax(int[] nums) {
        long m1 = Integer.MIN_VALUE - 1L, m2 = m1, m3 = m1;

        for (int x: nums) {
            if (m1 == x || m2 == x) continue;
            if (m1 < x) {
                m3 = m2;
                m2 = m1;
                m1 = x;
            } else if (m2 < x){
                m3 = m2;
                m2 = x;
            } else {
                m3 = Math.max(m3, x);
            }
        }
        return (int)(m3 == Integer.MIN_VALUE - 1L? m1: m3);
    }
}
