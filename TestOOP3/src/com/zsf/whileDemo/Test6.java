package com.zsf.whileDemo;

public class Test6 {
    public static void main(String[] args) {
        /*int i = 1;
        while (i<=100){
            int num = 2;
            boolean flag = true;
            while (num<i/2){
                if(i%num==0){
                    flag = false;
                }
                num++;
            }
            if(flag){
                System.out.println(i);
            }
            i++;
        }*/
        for (int i = 1; i <= 100; i++) {
            int num = 2;
            boolean flag = true;
            while (num<i/2){
                if(i%num==0){
                    flag = false;
                }
                num++;
            }
            if(flag){
                System.out.print(i+"\t");
            }
        }

    }
}
