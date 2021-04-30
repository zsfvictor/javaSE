package com.zsf.array;

public class Test4 {
    //奇数偶数分开存放
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,11,7,8,9,10};
        int o = 0;
        for(int i:arr) {
            if (i%2==0){
                o++;
            }
        }
        int[] en = new int[o];
        int[] on = new int[arr.length-o];
        int num1 = 0;
        int num2 = 0;
        for (int x :arr) {
            if (x%2==0){
                en[num1] = x;
                num1++;
            }else{
                on[num2] = x;
                num2++;
            }
        }
        for (int i:en) {
            System.out.print(i+"\t");
        }
        System.out.println();
        for (int j :on) {
            System.out.print(j+"\t");
        }
    }

}
