package com.zsf.array;

public class Test1 {
    public static void main(String[] args) {
        int[] a ={12,78,99,1,34,55,66};
        int[] b = new int[60];
        System.out.println(a[2]);
        a[0] = 20;
        System.out.println(a[0]);
        System.out.println(a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"\t");
        }
        System.out.println();
        for (int c:a){
            System.out.print(c+"\t");
        }
    }
}
