
/*

https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

Given an array where elements are sorted in ascending order,
convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

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
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return toBST(nums, 0, nums.length - 1);
    }


    public static TreeNode toBST(int[] nums, int beg, int end) {

        if (nums == null || end < beg) return null;
        int mid = beg + (end - beg) / 2;
        if (((end - beg) & 1) == 1) {
            if (nums[mid] < nums[mid + 1]) {
                mid = mid + 1;
            }
        }


        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums, beg, mid - 1);
        root.right = toBST(nums, mid + 1, end);
        return root;
    }
}
