package com.zsf.Lottery;

import java.util.Arrays;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] lotteries = new int[0][0];
        int[] lottery2 = new int[0];
        o:while (true) {
            System.out.println("1.购买双色球");
            System.out.println("2.查看双色球");
            System.out.println("3.开奖");
            System.out.println("4.查看中奖");
            System.out.println("5.退出");
            System.out.println("输入选项");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("运行购买双色球代码");
                    System.out.println("输入注数");
                    int num = sc.nextInt();
                    lotteries = new int[num][];
                    //循环生成双色球
                    for (int i = 0; i < lotteries.length; i++) {
                        lotteries[i] = GetLottery.getLottery();
                    }
                    break;

                case 2:
                    if (lotteries.length!=0){
                        for (int[] lottery : lotteries) {
                            for (int x : lottery) {
                                System.out.print(x + "\t");
                            }
                            System.out.println();
                        }
                    }else {
                        System.out.println("您还未购买");
                    }
                    break;
                case 3://开奖
                    if (lotteries.length!=0){
                        lottery2 = GetLottery.getLottery();
                        System.out.println(Arrays.toString(lottery2));
                    }else {
                        System.out.println("未购买");
                    }
                    break;
                case 4://查看中奖
                    if (lotteries.length!=0&&lottery2.length!=0){
                        GetLottery.isWin(lottery2,lotteries);
                    }else {
                        System.out.println("未购买并开奖");
                    }
                            break;


                case 5:
                    System.out.println("退出");
                    break o;
            }
        }
    }
}
