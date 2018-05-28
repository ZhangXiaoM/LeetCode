
/*

https://leetcode.com/problems/path-sum-iii/description/

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf,
but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

 */


package com.zmc;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Main {

    // space complexity O(N) because of recursive
    // time complexity O(N^2)
    public static void main(String[] args) {
	// write your code here
        // test case
        TreeNode node = new TreeNode(10);
        node.right = new TreeNode(-3);
        node.right.right = new TreeNode(11);
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(-2);
        root.right.right = new TreeNode(1);
        node.left = root;
        System.out.print(pathSum(node, 8));
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int cnt = dfs(root, sum, 0);
        return cnt + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    static int dfs(TreeNode root, int sum, int cur_sum) {
        if (root == null) return 0;

        int cnt = 0;
        cur_sum += root.val;
        if (cur_sum == sum) cnt ++;

        return cnt + dfs(root.left, sum, cur_sum) + dfs(root.right, sum, cur_sum);
    }
}
