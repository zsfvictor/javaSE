package com.zsf.whileDemo;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入整数");
        int num = sc.nextInt();//123456   654321
       //int i = 1;
        while(num!=0){
            System.out.print(num%10);
            num/=10;
            //i++;
        }
        sc.close();

    }
}