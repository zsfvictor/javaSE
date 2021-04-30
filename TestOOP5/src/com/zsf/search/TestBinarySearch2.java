package com.zsf.search;

public class TestBinarySearch2 {
    public static void main(String[] args) {
        //1.定义一个有序数组
        int[] array = {1,2,3,4,5,6,7,8,9};
        //折半查找，返回索引
        int key = 1;
        int index = binarySearch(array, key);
        System.out.println(index);
    }

    private static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length-1;

        int index = binarySearch(array,key,low,high);
        return index;
    }

    private static int binarySearch(int[] array, int key, int low, int high) {
        //递归的结束条件
        if (low>high){
            return -1;
        }
        //计算中间索引
        int mid = (low+high)/2;
        if (array[mid] == key){
            return mid;
        }else if (array[mid] > key){
            return binarySearch(array,key,low,mid-1);
        }else {
            return binarySearch(array,key,mid+1,high);
        }
    }
}
