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
