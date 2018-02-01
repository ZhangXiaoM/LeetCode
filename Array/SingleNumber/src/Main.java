
/*
https://leetcode.com/problems/single-number/description/

Given an array of integers, every element appears twice except for one.
Find that single one.

Note:
Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static int singleNumber(int[] nums) {
        if (nums == null) return -1;

        int res = 0;

        for(int n : nums) {
            res ^= n;
        }

        return res;
    }
}
