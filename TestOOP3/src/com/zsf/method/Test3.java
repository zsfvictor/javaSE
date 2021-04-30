package com.zsf.method;

import java.util.Arrays;

public class Test3 {
    //双色球
    public static void main(String[] args) {

        System.out.println(Arrays.toString(getLottery()));
    }
    public  static int[] getLottery(){
        int[] arr1 = new int[6];

        for (int i = 0; i < arr1.length; i++) {
            int num = (int)(Math.random()*33+1);
            while (isContain(arr1,num)) {
                num = (int)(Math.random()*33+1);
            }
                arr1[i] = num;
        }
        Arrays.sort(arr1);
        int[] arr2 = new int[7];
        System.arraycopy(arr1,0,arr2,0,6);
        int num2 = (int)(Math.random()*16+1);
        arr2[6] = num2;
        return arr2;
    }
    public static boolean isContain(int[] arr,int b){
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==b){
                //return true;
                flag = true;
                break;
            }

        }
        //return false;
        return flag;
    }
}
