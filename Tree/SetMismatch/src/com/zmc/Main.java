
/*

https://leetcode.com/problems/set-mismatch/description/

The set S originally contains numbers from 1 to n. But unfortunately,
due to the data error, one of the numbers in the set got duplicated to another number in the set,
which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error.
Your task is to firstly find the number occurs twice and then find the number that is missing.
Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Note:
The given array size will in the range [2, 10000].
The given array's numbers won't have any order.

 */




package com.zmc;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {2,3,2,4};
        int[] res = findErrorNums(nums);

    }

    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) return res;

        Map<Integer, Integer> map = new HashMap<>();

        for (int x: nums) {
            Integer temp = map.get(x);
            if (temp != null) {
                res[0] = x;
            } else {
                map.put(x, 1);
            }
        }

        for (int i = 1; i <= nums.length; ++i) {
            if (map.get(i) == null) {
                res[1] = i;
            }
        }

        return res;
    }
}
