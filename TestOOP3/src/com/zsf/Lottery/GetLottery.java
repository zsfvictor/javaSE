package com.zsf.Lottery;

import java.util.Arrays;

public class GetLottery {
    //判断中奖
    public static void isWin(int[] luckyNum,int[][] lottery){
        //判断前6位相同数
        int red = 0;
        int blue = 0;
        int money = 0;
        for (int i = 0; i < lottery.length; i++) {
            for (int j = 0; j < 6; j++)
                if (lottery[i][j] == luckyNum[j]) {
                    red += 1;
                }
            //判断第七位相同：
            blue = lottery[i][6] == luckyNum[6]?1:0;
            //判断多少钱
            if (red==6&&blue==1){
                money+=5000000;
                System.out.println("一等奖");
            }else if (red==6){
                money+=1250000;
                System.out.println("二等奖");
            }else if (red==5&&blue==1){
                money+=3000;
                System.out.println("三等奖");
            }else if (red==5||(red==4&&blue==1)){
                money+=200;
                System.out.println("四等奖");
            }else if (red==4||(red==3&&blue==1)){
                money+=10;
                System.out.println("五等奖");
            }else if(blue==1){
                money+=5;
                System.out.println("六等奖");
            }else {
                System.out.println("没中奖");
            }
            red = 0;
            blue = 0;
        }
        System.out.println("钱："+money);

    }
    //买双色球
     public  static int[] getLottery(){
        int[] arr1 = new int[6];

        for (int i = 0; i < arr1.length; i++) {
            int num = (int)(Math.random()*33+1);
            while (isContain(arr1,num)) {
                num = (int)(Math.random()*33+1);
            }
            arr1[i] = num;
        }
        Arrays.sort(arr1);
        int[] arr2 = new int[7];
        System.arraycopy(arr1,0,arr2,0,6);
        int num2 = (int)(Math.random()*16+1);
        arr2[6] = num2;
        return arr2;
    }
    public static boolean isContain(int[] arr,int b){
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==b){
                //return true;
                flag = true;
                break;
            }

        }
        //return false;
        return flag;
    }
}
