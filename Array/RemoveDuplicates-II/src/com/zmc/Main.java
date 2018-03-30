
/*

https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5,
with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.


 */


package com.zmc;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,2,2,2,3};
        removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        List<Integer> list = new ArrayList<>();
        int cnt = 1;
        int i = 0, j = 1;
        list.add(nums[0]);
        while (j < nums.length) {
            if (nums[j] == nums[i]) {
                cnt ++;
                if (cnt <= 2) {
                    list.add(nums[i]);
                }
                j ++;
            } else {
                i = j;
                cnt = 0;
            }
        }

        for (int k = 0; k < list.size(); ++k) {
            nums[k] = list.get(k);
        }

        return list.size();
    }
}
