package com.zsf.array;

import java.util.Arrays;

public class Test6 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,2,3,4,8,77,67,11,12,13,14};
        int[] arr2 = new int[10];
        System.arraycopy(arr1,2,arr2,3,5);
        arr1[0] = 100;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }
}
