package com.zsf.create;

/**
 * 定义一个线程类   乌龟线程
 */
public class TortoiseThread extends Thread{
    /**
     * 线程体：线程要执行的任务
     */
    @Override
    public void run() {
        while (true){
            System.out.println("乌龟跑"+this.getName()+"  "+this.getPriority());
        }
    }
}
