/**
 *
 * https://leetcode.com/problems/leaf-similar-trees/description/
 *
 * Consider all the leaves of a binary tree.  From left to right order,
 * the values of those leaves form a leaf value sequence.
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 *
 * Note:
 *
 * Both of the given trees will have between 1 and 100 nodes.
 */

package com.zmc;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
	// write your code here
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();

        inorder(root1, l1);
        inorder(root2, l2);

        return l1.equals(l2);
    }

    void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        if (root.left == null && root.right == null) list.add(root.val);
        inorder(root.right, list);
    }
}
