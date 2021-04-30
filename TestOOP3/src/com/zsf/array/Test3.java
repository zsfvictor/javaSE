package com.zsf.array;

public class Test3 {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6,7,8};
        int[] b ={9,10,11,12,13,14,15,16};
        
        int[] c = new int[a.length+b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[i+a.length] = b[i];
        }
        for (int x:c) {
            System.out.println(x);
        }
    }

}
