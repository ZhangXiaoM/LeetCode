package com.zmc;

/*

https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/

Given a Binary Search Tree (BST) with the root node root,
return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \
    1   3

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
Note:

The size of the BST will be between 2 and 100.
The BST is always valid, each node's value is an integer, and each node's value is different.

 */


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

    public static int minDiffInBST(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        preorder(list, root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); ++i) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    static void preorder(List list, TreeNode root) {
        if (root == null) return;
        preorder(list, root.left);
        list.add(root.val);
        preorder(list, root.right);
    }
}
