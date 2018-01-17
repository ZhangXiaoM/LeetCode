
/*
Given a circular array (the next element of the last element is the first element of the array),
print the Next Greater Number for every element.

The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
which means you could search circularly to find its next greater number.
If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number;
The second 1's next greater number needs to search circularly, which is also 2.
Note: The length of given array won't exceed 10000.
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {1,8,-1,-100,-1,222,1111111,-111111};
        System.out.println(nextGreaterElements(nums).toString());
    }

    public static int[] nextGreaterElements(int[] nums) {

        int[] res = new int[nums.length];

        int[] temp = new int[nums.length * 2];

        for (int i = 0; i < temp.length; ++ i) {
            temp[i] = nums[i % nums.length];
        }

        for (int i = 0; i < nums.length; ++i) {
            res[i] = -1;
            if (nums[i] == Integer.MAX_VALUE) continue;

            for (int j = i + 1; j < temp.length - 1; ++j) {
                if (temp[j] > nums[i]) {
                    res[i] = temp[j];
                    break;
                }
            }
        }

        return res;
    }
}
