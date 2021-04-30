package com.zsf.whileDemo;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int num = 2;
/*        int j = 0;
        while (num<i-1){
            if (i%num==0){
                j+=1;
            }
            num++;
        }
        if (j==0){
            System.out.println("是素数");
        }else{
            System.out.println("不是素数");
        }*/
        boolean flag = true;
        while (num<i){
            if (i%num==0){
                flag = false;
            }
            num++;
        }
        if (flag==true){
            System.out.println("是素数");
        }else{
            System.out.println("不是素数");
        }
        sc.close();
    }
}
