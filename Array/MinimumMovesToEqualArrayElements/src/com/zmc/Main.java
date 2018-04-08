
/*

https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/

Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal,
where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]


we define that min is the min num of the list,
des is the destination equable number,
sum is the sum of elements in the list,
m is the minimum moves.
we can get:

sum + m * (n - 1) = des * n;

des equal min add m.

so,

sum + m * n - m = min * n + m * n.

m = sum - min * n.

 */


package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int minMoves(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int sum = 0, min = nums[0];
        for (int x: nums) {
            min = Math.min(x, min);
            sum += x;
        }

        return sum - min * nums.length;
    }
}
