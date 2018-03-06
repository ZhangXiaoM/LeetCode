


package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(climbStairs(4));
    }

    public static int climbStairs(int n) {

        if(n == 0 || n == 1 || n == 2) return n;

        int f0 = 1,f1 = 1;

        int result = 0;

        for(int i = 2; i <= n; i++) {
            result = f0 + f1;
            f1 = f0;
            f0 = result;
        }
        return result;
    }
}
