package com.zsf.array;

public class Test8 {
    //二维数组
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4}, {2,3,4,5}, {3,4,5,6}, {4,5,6,7}};
        System.out.println(arr[2][3]);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
        for (int[] x:arr) {
            for (int i:x) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }
        System.out.println();
        int[][] arr2 = new int[2][2];
        arr2[0][0] = 1;
        arr2[0][1] = 2;
        arr2[1][0] = 3;
        arr2[1][1] = 4;
        for (int[] x:arr2) {
            for (int i:x) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }

    }

}
