package com.zsf.whileDemo;

public class test1 {
    public static void main(String[] args) {
        int i = 1;
        int j = 1;
        while (i<=100){
            if (i%5==0){
                System.out.print(i+"\t");
                if (j%3==0){
                    System.out.println();
                }
            }
            j++;
            i++;
        }
    }

}
