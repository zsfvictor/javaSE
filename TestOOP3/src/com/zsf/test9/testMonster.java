package com.zsf.test9;

public class testMonster {
    public static void main(String[] args) {
        int w = 315;
        int g = 500;
        int i = 1;
        while(true){
            System.out.println("-----------第"+i+"回合-------------");
            i++;
            //玩家攻击力
            int wg = (int)(Math.random()*4)+5;
            g -= wg;
            System.out.println("怪物掉了多少血"+wg+"还剩多少血"+g);
            if (g<=0){
                System.out.println("怪物死掉了");
                break;
            }
            //怪物攻击力
            int gg = (int)(Math.random()*3)+3;
            w -=gg;
            System.out.println("玩家掉了多少血"+gg+"还剩多少血"+w);
            if (w<=0){
                System.out.println("玩家死掉了");
                break;
            }
        }
    }
}
