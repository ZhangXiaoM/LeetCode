
/*



 */


package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(arrangeCoins(1804289383));
    }

    public static int arrangeCoins(int n) {
        if (n <= 0) return 0;

        long left = 1, right = n;

        while (true) {
            long mid = left + (right - left) / 2;

            long sum = (1 + mid) * mid / 2 ;

            if (sum > n) {
                right = mid - 1;
            } else if (sum < n) {
                if ((1 + mid + 1) * (mid + 1) / 2 > n) {
                    return (int)mid;
                }
                left = mid + 1;
            } else {
                return (int)mid;
            }
        }
    }

    public static int arrangeCoins2(int n) {
        // sum = x * (x + 1) / 2
        // sum < n
        if (n <= 0) return 0;
        return (int)((Math.sqrt(1 +(8 * (long)n) - 1) / 2));
    }
}
