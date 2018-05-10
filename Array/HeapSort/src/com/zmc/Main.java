package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] arr = {4,1,3,2,16,9,10,14,8,7};
        sort(arr);
        System.out.print(arr);
    }

    static void maxHeapify(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * (i + 1);
        int iMax = i;
        if (left < size && arr[i] < arr[left]) {
            iMax = left;
        }
        if (right < size && arr[iMax] < arr[right]) {
            iMax = right;
        }

        if (i != iMax) {
            swap(arr, i, iMax);
            maxHeapify(arr, iMax, size);
        }
    }

    static void buildMaxHeap(int[] arr, int size) {
        int cnt = size / 2 - 1;
        for (int i = cnt; i >= 0; --i) {
            maxHeapify(arr, i, arr.length);
        }
    }

    static void sort(int[] arr) {
        buildMaxHeap(arr, arr.length);
        for (int i = arr.length - 1; i > 0; --i) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }
    }

    static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}


