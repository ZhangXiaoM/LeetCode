
/*

https://leetcode.com/problems/spiral-matrix/description/

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].


 */

package com.zmc;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] m = {{7,8}, {9,10}};
        System.out.print(spiralOrder(m));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;
        circle(matrix, matrix.length, matrix[0].length, 0, 0, list);
        return list;
    }

    static void circle(int[][] matrix, int er, int ec, int sr, int sc, List<Integer> list) {
        if (matrix == null || sr >= er || sc >= ec) return;

        int i = sr, j = sc;

        while (j < ec) list.add(matrix[i][j ++]);
        if (++ i == er) return;
        j--;
        while (i < er) list.add(matrix[i ++][j]);
        if (j == sc) return;
        -- j;
        i --;
        while (j >= sr) list.add(matrix[i][j --]);
        i --; j ++;
        while (i > sc) list.add(matrix[i --][j]);
        i ++; j ++;
        circle(matrix, er - 1, ec - 1, i, j, list);
    }
}
