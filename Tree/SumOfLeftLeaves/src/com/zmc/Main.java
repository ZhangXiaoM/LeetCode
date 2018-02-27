
/*

https://leetcode.com/problems/sum-of-left-leaves/description/

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively.
Return 24.
 */

package com.zmc;

import java.util.ArrayList;

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


    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);
        int sum = 0;
        for (int v : list) {
            sum += v;
        }
        return sum;
    }

    void dfs(TreeNode root, ArrayList list) {
        if (root == null) return;
        if (root.left != null && root.left.left == null && root.left.right == null)
            list.add(root.left.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
