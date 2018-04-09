
/*

https://leetcode.com/problems/binary-tree-tilt/description/

Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values.
Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input:
         1
       /   \
      2     3
Output: 1
Explanation:
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
Note:

The sum of node values in any subtree won't exceed the range of 32-bit integer.
All the tilt values won't exceed the range of 32-bit integer.

 */



package com.zmc;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Main {

    static int cur_titls = 0;

    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.print(findTilt(root));
    }

    public static int findTilt(TreeNode root) {
        if (root == null) return 0;
        getTilt(root);
        return cur_titls;
    }

    static int getTilt(TreeNode root) {
        if (root == null) return 0;
        int left = getTilt(root.left);
        int right = getTilt(root.right);

        cur_titls += Math.abs(left - right);

        return left + right + root.val;
    }
}
