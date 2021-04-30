package com.zsf.synch0;

public class TestAccount {
    public static void main(String[] args) {
        //1.创建2个线程，模拟两个用户
        Runnable runnable = new AccountRunnable();
        Thread thread1 = new Thread(runnable,"张三");
        Thread thread2 = new Thread(runnable,"李四");
        //启动两个线程，模拟两个用户一起
        thread1.start();
        thread2.start();
    }
}
