
/*

https://leetcode.com/problems/subtree-of-another-tree/description/

Given two non-empty binary trees s and t,
check whether tree t has exactly the same structure and node values with a subtree of s.
A subtree of s is a tree consists of a node in s and all of this node's descendants.
The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
 */



package com.zmc;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(1);
        TreeNode t = new TreeNode(1);
        System.out.print(isSubtree(s, t));
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val == t.val) {
            boolean isSame = isSameTree(s, t);
            if (isSame) return isSame;
            else return isSubtree(s.left, t) || isSubtree(s.right, t);
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }


    static boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        boolean isSame = s.val == t.val;

        return isSame && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
