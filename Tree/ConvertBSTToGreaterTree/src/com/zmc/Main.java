
/*

https://leetcode.com/problems/convert-bst-to-greater-tree/description/

Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13

 */


package com.zmc;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Main {

    static int cur_sum = 0;

    public static void main(String[] args) {
	    // write your code here
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);
        TreeNode pRoot = convertBST(root);
    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convert(root);
        return root;
    }

    static void convert(TreeNode root) {
        if (root == null) return;

        convert(root.right);
        cur_sum += root.val;
        root.val = cur_sum;
        convert(root.left);
    }
}
