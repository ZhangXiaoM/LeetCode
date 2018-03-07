package com.zmc;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(isHappy(2));
    }

    public static boolean isHappy(int n) {

        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            int temp = n, sum = 0;
            while (temp != 0) {
                int remian = temp % 10;
                sum += remian * remian;
                temp /= 10;
            }

            if (list.contains(sum)) return false;

            if (sum == 1) return true;
            else list.add(sum);
            n = sum;
        }

        return true;
    }
}
