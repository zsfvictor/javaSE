package com.zsf.synch4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步方法
 */
public class TestRunnable3 implements Runnable{
    private int ticketNum = 200;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            //对买一张票这个过程上锁
            lock.lock();
            try {
                if (ticketNum<=0){
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"卖出了第"+ticketNum+"张票");
                ticketNum--;
            }finally {
                //开锁
                lock.unlock();
            }
        }
    }
    public synchronized void sellOne(){

    }

    public static void main(String[] args) {
        Runnable runnable = new TestRunnable3();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
    }
}
