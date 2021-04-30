package com.zsf.method;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int a = getsSum(arr);
        System.out.println(a);
        double b = getAva(arr);
        System.out.println(b);
    }

    public static double getAva(int[] arr){
       /* int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }*/
        int sum = getsSum(arr);
        return sum*1.0/arr.length;
    }
    public static int getsSum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
