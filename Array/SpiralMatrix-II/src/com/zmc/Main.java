
/*

https://leetcode.com/problems/spiral-matrix-ii/description/

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

 */


package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(generateMatrix(4));
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n <= 0) return res;
        circle(res, 0, n, 1);
        return res;
    }

    static void circle(int[][] res, int start, int end, int num) {

        if (start >= end) return;

        int i = start, j = start;
        while (j < end) res[i][j ++] = num ++;
        j --; i ++;
        while (i < end) res[i ++][j] = num ++;
        i --; j --;
        while (j >= start) res[i][j --] = num ++;
        j ++; i --;
        while (i > start) res[i --][j] = num ++;
        circle(res, start + 1, end - 1, num);
    }
}
