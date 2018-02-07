
/*

https://leetcode.com/problems/remove-element/description/

Given an array and a value, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array,
you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.
 */


public class Main {

    public static void main(String[] args) {
        int[] nums = {0,4,4,0,4,4,4,0,2};
        System.out.println(removeElement(nums,4));
    }

    public static int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) return 0;

        int i = 0, j = nums.length - 1, N = nums.length;

        while (i <= j) {
            if (nums[i] == val) {
                if (nums[j] != val) nums[i] = nums[j];
                j --;
                N--;
            } else i ++;
        }
        return N;
    }
}
