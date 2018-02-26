
/*

https://leetcode.com/problems/invert-binary-tree/description/

Invert a binary tree.
     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet (https://twitter.com/mxcl/status/608682016205344768) by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew),
but you can’t invert a binary tree on a whiteboard so fuck off.

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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;
    }
}
