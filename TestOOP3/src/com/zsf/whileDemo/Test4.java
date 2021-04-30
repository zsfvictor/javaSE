package com.zsf.whileDemo;

public class Test4 {
    public static void main(String[] args) {
        int num = 100;
        while (num<=1000){
            int num1 = num;
            int i = num1%10;
            num1/=10;
            int j = num1%10;
            num1/=10;
            int k = num1%10;
            int num2 = i*i*i+j*j*j+k*k*k;
            if (num == num2){
                System.out.println(num2);
            }
            num++;
        }
        System.out.println(num);
    }

}
