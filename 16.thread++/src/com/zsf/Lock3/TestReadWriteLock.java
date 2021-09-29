package com.zsf.Lock3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class TestReadWriteLock {
    public static void main(String[] args) {
        Operator operator = new Operator();
        //5个读线程并启动
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                while (true){
                    operator.read();
                }

            }
        };
        for (int i = 0; i < 5; i++) {
            new Thread(runnable1,"读线程"+i).start();
        }
        //创建5个写线程
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                while (true){
                    operator.write();
                }

            }
        };
        for (int i = 0; i < 5; i++) {
            new Thread(runnable2,"写线程"+i).start();
        }
    }
}


class Operator{
    //private Lock lock = new ReentrantLock();
        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void read(){
        //lock.lock();
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读数据开始");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"读数据结束");
        } finally {
            //lock.unlock();
            readWriteLock.readLock().unlock();
        }

    }

    public void write(){
        readWriteLock.writeLock().lock();
        //lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写数据开始");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"写数据结束");
        } finally {
            //lock.unlock();
            readWriteLock.writeLock().unlock();
        }

    }
}