package com.zsf.synch4;

/**
 * 同步方法
 */
public class TestRunnable2 implements Runnable{
    private int ticketNum = 200;
    @Override
    public void run() {
        while (true){
            sellOne();
            if (ticketNum<=0){
                break;
            }

        }
    }
    public synchronized void sellOne(){
        if (ticketNum<=0){
            return;
        }
        System.out.println(Thread.currentThread().getName()+"卖出了第"+ticketNum+"张票");
        ticketNum--;
    }

    public static void main(String[] args) {
        Runnable runnable = new TestRunnable2();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
    }
}
