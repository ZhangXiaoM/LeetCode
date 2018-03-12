
/*

https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
 */


package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] prices = {7, 2, 5, 3, 6, 4, 1, 16};
        System.out.print(maxProfit(prices));
    }

    // time complexity O(N^2)  submission error time limit exceeded
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int maxDif = 0;
        for (int i = 0; i < prices.length; ++i) {
            for (int j = i; j < prices.length; ++j) {
                int dif = prices[j] - prices[i];
                maxDif = Math.max(maxDif, dif);
            }
        }
        return maxDif;
    }

    // time complexity O(N)
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int maxDif = 0, leftMin = prices[0];

        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > leftMin) {
                maxDif = Math.max(maxDif, prices[i] - leftMin);
            } else {
                leftMin = prices[i];
            }
        }

        return maxDif;
    }
}
