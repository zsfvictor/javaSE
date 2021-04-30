package com.zsf.forDemo;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入一个数");
        int num = sc.nextInt();
        int j = 1;
        for (int i = 1; i <= num; i++) {
            j*=i;
        }
        System.out.println(j);
        sc.close();
    }
}
