
/*

https://leetcode.com/problems/count-primes/description/

Count the number of prime numbers less than a non-negative number, n.
 */


package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(countPrimes(1500000));
    }
    // time limit exceeded
    public static int countPrimes(int n) {
        if (n <= 0) return 0;
        int cnt = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    static boolean isPrime(int num) {
        if (num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); ++i) {
            if (num % i == 0) return false;
        }

        return true;
    }


    public static int countPrimes2(int n) {
        if (n <= 0) return 0;
        int cnt = 0;
        boolean[] notPrimes = new boolean[n];
        for (int i = 2; i < n; ++i) {
            if (!notPrimes[i]) {
                cnt++;
                for (int j = 2; i * j < n; ++j) {
                    notPrimes[i * j] = true;
                }
            }
        }

//        for (int i = 2; i < n; ++i) {
//            if (!notPrimes[i]) cnt++;
//        }

        return cnt;
    }
}
