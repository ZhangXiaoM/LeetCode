package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] a = {1,5,2,3,4,8};
        sort(a);
    }

    static void sort(int[] a) {
        int[] b = new int[a.length];
        merge(a, b, 0, a.length - 1);
    }

    static void merge(int[] a, int[] b, int i, int j) {
        if (i >= j) return;
        int mid = i + (j - i) / 2, idx = i;
        int s1 = i, e1 = mid;
        int s2 = mid + 1, e2 = j;
        merge(a, b, s1, e1);
        merge(a, b, s2, e2);

        while (s1 <= e1 && s2 <= e2) {
            if (a[s1] < a[s2]) {
                b[idx] = a[s1 ++];
            } else {
                b[idx] = a[s2 ++];
            }
            idx ++;
        }

        while (s1 <= e1) {
            b[idx ++] = a[s1 ++];
        }

        while (s2 <= e2) {
            b[idx ++] = a[s2 ++];
        }

        for (int k = i; k <= j; k++) {
            a[k] = b[k];
        }
    }
}
