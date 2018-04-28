
/*

https://leetcode.com/problems/pascals-triangle/description/

 */


package com.zmc;

import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        if (numRows <= 0) return res;

        for (int i = 0; i < numRows; ++i) {
            List<Integer> rowList = new ArrayList<>();

            if (i <= 1) {
                for (int k = 0; k <= i; ++k)
                    rowList.add(1);
            } else {

                for (int j = 0; j <= i; ++j) {
                    if (j == 0 || j == i) rowList.add(1);
                    else rowList.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(rowList);
        }
        return res;
    }
}
