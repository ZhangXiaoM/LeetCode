
/*

https://leetcode.com/problems/largest-triangle-area/description/

You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.

Example:
Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
Output: 2
Explanation:
The five points are show in the figure below. The red triangle is the largest.

Notes:

3 <= points.length <= 50.
No points will be duplicated.
 -50 <= points[i][j] <= 50.
Answers within 10^-6 of the true value will be accepted as correct.

 */



package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] points = {{35,-23},{-12,-48},{-34,-40},{21,-25},{-35,-44},{24,1},{16,-9},{41,4},{-36,-49},{42,-49},{-37,-20},{-35,11},{-2,-36},{18,21},{18,8},{-24,14},{-23,-11},{-8,44},{-19,-3},{0,-10},{-21,-4},{23,18},{20,11},{-42,24},{6,-19}};

        System.out.print(largestTriangleArea(points));
    }

    // time complexity O(N ^ 3)
    public static double largestTriangleArea(int[][] points) {

        if (points == null || points.length == 0) return 0;

        double max = 0;

        for (int i = 0; i < points.length - 2; ++i) {
            for (int j = i + 1; j < points.length - 1; ++j) {
                for (int k = j + 1; k < points.length; ++k) {
                    double area = area(points[i], points[j], points[k]);
                    max = Math.max(area, max);
                }
            }
        }
        return max;
    }

    // get area with formula: s = sqrt(c/2 * (c/2 - a) * (c/2 - b) * (c/2 - c))
    public static double area(int[] p1, int[] p2, int[] p3) {

        if (p1 == null || p2 == null || p3 == null) return 0;

        double d12 = Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
        double d13 = Math.sqrt(Math.pow(p1[0] - p3[0], 2) + Math.pow(p1[1] - p3[1], 2));
        double d23 = Math.sqrt(Math.pow(p2[0] - p3[0], 2) + Math.pow(p2[1] - p3[1], 2));

        double perimeter = (d12 + d13 + d23) / 2;

        return Math.sqrt(Math.abs(perimeter * (perimeter - d12) * (perimeter - d13) * (perimeter - d23)));
    }

}
