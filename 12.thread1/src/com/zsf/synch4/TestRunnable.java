package com.zsf.synch4;

/**
 * 同步代码快方案
 */
public class TestRunnable implements Runnable{
    private int ticketNum = 200;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                if (ticketNum<=0){
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"卖出了第"+ticketNum+"张票");
                ticketNum--;
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new TestRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
    }
}
