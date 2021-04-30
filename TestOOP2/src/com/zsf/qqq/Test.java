package com.zsf.qqq;

public class Test {
    public static void main(String[] args) {
        Gril g = new Gril();
        /*g.age = 18;
        System.out.println(g.age);*/
        //设置年龄：
        g.setAge(33);
        //读取年龄
        System.out.println(g.loadAge());
    }
}
