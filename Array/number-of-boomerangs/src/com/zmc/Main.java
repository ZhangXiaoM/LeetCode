
/*

https://leetcode.com/problems/number-of-boomerangs/description/

Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

 */


package com.zmc;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] points = {{0,0},{1,0},{2,0}};
        System.out.print(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int cnt = 0;

        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; ++i) {
            for (int j = 0; j < points.length; ++j) {
                if (i == j) continue;
                double dis = getDistance(points[i], points[j]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (int temp: map.values()) {
                cnt += temp * (temp - 1);
            }
            map.clear();
        }

        return cnt;
    }

    static double getDistance(int[] p1, int[] p2) {
        double px = Math.pow(p1[0] - p2[0], 2);
        double py = Math.pow(p1[1] - p2[1], 2);

        return px + py;
    }
}
