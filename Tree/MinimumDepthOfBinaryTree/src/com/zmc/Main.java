
/*

https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null)	return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
