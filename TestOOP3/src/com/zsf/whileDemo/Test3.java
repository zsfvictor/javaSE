package com.zsf.whileDemo;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int num1 = num;
        int i = num%10;
        num/=10;
        int j = num%10;
        num/=10;
        int k = num%10;
        int num2 = i*i*i+j*j*j+k*k*k;
        if(num1==num2){
            System.out.println("水仙花数");
        }else{
            System.out.println("非水仙花数");
        }

    }
}
