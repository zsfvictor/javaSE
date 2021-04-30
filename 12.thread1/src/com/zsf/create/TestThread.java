package com.zsf.create;

/**
 * 创建一个线程类，并启动线程
 */
public class TestThread {
    public static void main(String[] args) {
        //启动乌龟线程
        TortoiseThread thread = new TortoiseThread();
        //thread.run();   普通的方法调用
        thread.start();
        //兔子跑
        while(true){
            System.out.println("兔子跑"+ Thread.currentThread().getName()
            +"   "+Thread.currentThread().getPriority());
        }

    }
}
