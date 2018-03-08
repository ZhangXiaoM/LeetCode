
/*

https://leetcode.com/problems/first-bad-version/description/

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check.
Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version.
You should minimize the number of calls to the API.
 */

package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(firstBadVersion(10));
    }

    static boolean isBadVersion(int version) {
        return version >= 5;
    }

    public static int firstBadVersion(int n) {

        int lo = 1; int hi = n;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (!isBadVersion(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}
