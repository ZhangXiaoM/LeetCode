
/*

https://leetcode.com/problems/subsets/description/

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */



package com.zmc;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1, 2, 3};
        System.out.print(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(res, subset, nums, 0);

        return res;
    }

    static void dfs(List<List<Integer>> res, List<Integer> subset, int[] nums, int beg) {

        res.add(new ArrayList<>(subset));

        for (int i = beg; i < nums.length; ++i) {
            subset.add(nums[i]);
            dfs(res, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
