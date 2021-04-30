package com.zsf.test9;

public class Test3 {
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;
/*        while (i<=100){
            System.out.println(i);
            i = i + 2;
        }*/
        while (i<=100){
            if(i%2!=0){
                sum += i;
            }
            i++;
        }
        System.out.println(sum);
    }


}
