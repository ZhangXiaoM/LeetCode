/*

https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/

Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.

 */


package com.zmc;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); ++ i) {
            min = Math.min(min, Math.abs(list.get(i) - list.get(i - 1)));
        }
        return min;
    }

    void preorder(TreeNode root, List list) {
        if (root == null) return;

        preorder(root.left, list);
        list.add(root.val);
        preorder(root.right, list);
    }
}
