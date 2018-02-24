
/*

https://leetcode.com/problems/majority-element-ii/description/

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
The algorithm should run in linear time and in O(1) space.
 */

package com.zmc;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {0,3,4,0};
        System.out.print(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        if (nums == null) return null;
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;

        int n1 = nums[0], n2 = nums[0], c1 = 0, c2 = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == n1) {
                c1 ++;
            } else if (nums[i] == n2) {
                c2 ++;
            } else if (c1 == 0) {
                n1 = nums[i];
                c1 = 1;
            } else if (c2 == 0) {
                n2 = nums[i];
                c2 = 1;
            } else {
                c1 --;
                c2 --;
            }
        }

        if (isMoreThanOneThird(nums, n1)) res.add(n1);
        if (isMoreThanOneThird(nums, n2) && !res.contains(n2)) res.add(n2);

        return res;
    }

    private static boolean isMoreThanOneThird(int[] nums, int key) {
        int cnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == key) cnt ++;
        }

        return cnt > nums.length / 3;
    }
}
