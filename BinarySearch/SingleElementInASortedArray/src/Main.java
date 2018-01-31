
/*

https://leetcode.com/problems/single-element-in-a-sorted-array/description/

Given a sorted array consisting of only integers where every element appears twice except for one element which appears once.
Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10
Note: Your solution should run in O(log n) time and O(1) space.
 */

public class Main {

    public static void main(String[] args) {
        int[] nums = {3,3,10,7,7,11,11};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int low = 0, high = nums.length - 1;

        while (low < high) {

            int mid = (low + high) / 2;
            int temp = (mid & 1) == 1? -1 : 1;
            if (nums[mid] == nums[mid + temp]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }
}
