package com.zsf.search;



public class TestBinarySearch {
    public static void main(String[] args) {
        //1.定义一个有序数组
        int[] array = {1,2,3,4,5,6,7,8,9};
        //折半查找，返回索引
        int key = 8;
        int index = binarySearch(array, key);
        System.out.println(index);
    }

    private static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length-1;
        while (low<=high){
            //计算mid的值
            int mid = (low+high)/2;

            //根据mid的值判断
            if (array[mid] == key){
                return mid;
            }else if (array[mid]>key){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        //不存在
        return  -1;
    }
}
