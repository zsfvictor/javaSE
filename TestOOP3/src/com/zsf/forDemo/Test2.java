package com.zsf.forDemo;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
/*        int code = sc.nextInt();
        while (code<100000||code>999999){
            System.out.println("密码不正确，请重新输入");
            code = sc.nextInt();
        }*/
        for (int i = 2; i >=0 ;i--) {
            System.out.println("请输入密码");
            int code = sc.nextInt();
            while (code<100000||code>999999){
                System.out.println("密码不正确，请重新输入");
                code = sc.nextInt();
            }
            if (code==123456){
                System.out.println("欢迎");
                break;
            }else{
                if (i==0){
                    System.out.println("三次错误");
                }else {
                    System.out.println("重新输入");
/*                    code = sc.nextInt();
                    while (code < 100000 || code > 999999) {
                        System.out.println("密码不正确，请重新输入");
                        code = sc.nextInt();
                    }*/
                }
            }
        }
    }
}
