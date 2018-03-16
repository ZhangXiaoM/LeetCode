
/*

https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/

Given a non-empty special binary tree consisting of nodes with the non-negative value,
where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes,
then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:
Input:
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:
Input:
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.

 */


package com.zmc;

import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        findSecondMinimumValue(root);
    }

    public static int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        Set<Integer> set = new HashSet<>();
        dfs(root, set);
        if (set.size() == 1) return -1;
        int min = Integer.MAX_VALUE;
        for (int i : set) {
            if (i == root.val) continue;
            min = Math.min(i, min);
        }
        return min;
    }
    
    // a bad solution by dfs
    static void dfs(TreeNode node, Set<Integer> set) {
        if (node == null) return;
        set.add(node.val);
        dfs(node.left, set);
        dfs(node.right, set);
    }
}
