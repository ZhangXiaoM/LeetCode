
/*

https://leetcode.com/problems/path-sum-ii/description/

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */


package com.zmc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> t = new Stack<>();
        getPath(root, sum, list, t);
        return list;
    }

    static void getPath(TreeNode root, int sum, List<List<Integer>> list, Stack<Integer> t) {
        if (root == null) return;
        t.push(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum)
                list.add(new ArrayList<>(t));
        }
        getPath(root.left, sum - root.val, list, t);
        getPath(root.right, sum - root.val, list, t);
        t.pop();
    }
}
