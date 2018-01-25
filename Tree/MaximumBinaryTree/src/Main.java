
/*

https://leetcode.com/problems/maximum-binary-tree/description/

Given an integer array with no duplicates.
A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray
divided by the maximum number.

The right subtree is the maximum tree constructed from right part subarray
divided by the maximum number.

Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    /
     2  0
       \
        1
Note:
The size of the given array will be in the range [1,1000].

*/


public class Main {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        System.out.println(constructMaximumBinaryTree(nums));
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        TreeNode node = creatNode(nums, 0, nums.length - 1);
        return node;
    }

    public static TreeNode creatNode(int[] nums, int left, int right) {
        if (left < 0 || right >= nums.length || left > right)
            return null;

        int max = -1;
        int maxIndex = -1;
        for (int i = left; i <= right; ++i) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = creatNode(nums, left, maxIndex - 1);
        node.right = creatNode(nums, maxIndex + 1, right);

        return node;
    }
}
