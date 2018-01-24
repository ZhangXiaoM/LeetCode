
/*

https://leetcode.com/problems/perfect-number/description/

We define the Perfect Number is a positive integer
that is equal to the sum of all its positive divisors except itself.

Now, given an integer n, write a function that returns true
when it is a perfect number and false when it is not.

Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
Note: The input number n will not exceed 100,000,000. (1e8)

 */

public class Main {

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(100));
    }

    public static boolean checkPerfectNumber(int num) {

        int sum = 1;
        for (int i = 2; i < Math.sqrt(num); i++)
            if (num % i == 0) {
                int x = i + (num/i == i ? 0 : num/i);
                sum += x;
            }
        return num != 1 && sum == num;
    }
}
