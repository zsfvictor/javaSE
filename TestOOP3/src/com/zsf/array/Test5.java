package com.zsf.array;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        int[] arr ={1,8,3,7,6,9,84,2};
        for (int i :arr) {
            System.out.print(i+"\t");
        }
        //排序功能
        Arrays.sort(arr);
        System.out.println();
        for (int i :arr) {
            System.out.print(i+"\t");
        }
        System.out.println();
        //快速查位置
        int index = Arrays.binarySearch(arr, 8);
        System.out.println(index);
        //快速遍历数组
        String arrs = Arrays.toString(arr);
        System.out.println(arrs);
        System.out.println("-----------------");
        int[] arr1 = {4,2,3,4,8,77,67};
        int[] arr2 = Arrays.copyOf(arr1,arr1.length);
        arr1[2] = 100;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }
}
