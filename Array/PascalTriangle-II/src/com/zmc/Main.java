
/*
    https://leetcode.com/problems/pascals-triangle-ii/description/
 */

package com.zmc;

import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(getRow(30));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList();
        if (rowIndex < 0) return res;
        res.add(1);

        for (int i = 1; i <= rowIndex; ++i) {
            long mu = (long)res.get(i - 1) * (rowIndex - i + 1);
            res.add((int)(mu / i));
        }

        return res;
    }
}
