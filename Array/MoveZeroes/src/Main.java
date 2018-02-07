
/*

https://leetcode.com/problems/move-zeroes/description/

Given an array nums, write a function to move all 0's to the end of it
while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function,
nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

 */

public class Main {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(nums);
    }

    public static void moveZeroes(int[] nums) {
        
        if (nums == null) return;

        int m = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[m++] = nums[i];
            }
        }

        for (int j = m; j < nums.length; ++j) {
            nums[j] = 0;
        }
    }
}
