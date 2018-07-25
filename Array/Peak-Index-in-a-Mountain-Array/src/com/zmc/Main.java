
/*

https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

Let's call an array A a mountain if the following properties hold:

A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

Example 1:

Input: [0,1,0]
Output: 1
Example 2:

Input: [0,2,1,0]
Output: 1
Note:

3 <= A.length <= 10000
0 <= A[i] <= 10^6
A is a mountain, as defined above.

 */


package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] A = {3,4,5,1};
        peakIndexInMountainArray1(A);
    }


    // time O(N)
    public int peakIndexInMountainArray(int[] A) {
        if (A == null || A.length < 3) return -1;

        for (int i = 1; i < A.length - 1; ++i) {
            if (A[i] >= A[i - 1] && A[i] <= A[i + 1])
                return i;
        }
        return -1;
    }

    public static int peakIndexInMountainArray1(int[] A) {
        if (A == null || A.length < 3) return -1;

        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] < A[mid + 1]) {
                lo = mid + 1;
            } else if (A[mid] < A[mid - 1]) {
                hi = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
