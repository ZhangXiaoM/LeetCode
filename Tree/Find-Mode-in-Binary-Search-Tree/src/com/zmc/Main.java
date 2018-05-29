
/*

https://leetcode.com/problems/find-mode-in-binary-search-tree/description/

Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).


 */

package com.zmc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
//        root.left.right = new TreeNode(0);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        System.out.print(findMode(root));
    }

    public static int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        preorder(root, map);

        int max = 0;
        for (int i: map.keySet()) {
            int cnt = map.get(i);
            if (cnt > max) {
                list.clear();
                list.add(i);
                max = cnt;
            } else if (cnt == max) {
                list.add(i);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    static void preorder(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        preorder(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        preorder(root.right, map);
    }
}
