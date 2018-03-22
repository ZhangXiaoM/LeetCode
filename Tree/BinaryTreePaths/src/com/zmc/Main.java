
/*

https://leetcode.com/problems/binary-tree-paths/description/

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        binaryTreePaths(root);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        getPath(root, list, "");

        return list;
    }

    static void getPath(TreeNode node, List<String> list, String s) {
        if (node.left == null && node.right == null) list.add(s + node.val);
        if (node.left != null) getPath(node.left, list, s + node.val + "->");
        if (node.right != null) getPath(node.right, list, s + node.val + "->");
    }
}
