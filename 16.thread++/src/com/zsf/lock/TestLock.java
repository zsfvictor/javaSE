package com.zsf.lock;

import sun.plugin.ClassLoaderInfo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestLock {

    Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        //Lock
        /**1可重入锁    Lock ReadWriteLock  synchroniazied锁都是可重入锁
         * 2独占锁和共享锁     ReadLock 共享锁   WriteLock   ReentrantLock synchroniazied锁  独占锁
         *  3公平锁和非公平锁
         */
        Lock lock1 = new ReentrantLock();
        //获取锁1：拿不到锁就一直等待，拿到就执行后续代码
        lock1.lock();
        //获取锁2：拿不到返回false，拿到就返回true
        boolean flag = lock1.tryLock();
        //获取锁3：如果拿不到锁，就尝试一段时间。时间到了还没有获取锁，才放弃
        boolean flag2 = lock1.tryLock(10, TimeUnit.MILLISECONDS);
        //获取锁4：拿不到锁就一直等待，中途可以被其他线程中断
        lock1.lockInterruptibly();
        //解锁
        lock1.unlock();
        //产生一个新的等待队列
        lock1.newCondition();

        //ReadWriteLock
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock1 = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock1 = reentrantReadWriteLock.writeLock();
        ReentrantReadWriteLock.WriteLock writeLock2 = reentrantReadWriteLock.writeLock();
        System.out.println(readLock1 == readLock2);
        System.out.println(writeLock1 == writeLock2);
    }

    public void method1() {
        lock.lock();//1
        try {
            method2();
        } finally {
            lock.unlock();//0
        }
    }

    public void method2() {
        lock.lock();//2
        try {
            method3();
        } finally {
            lock.unlock();//1
        }
    }

    public void method3() {
        lock.lock();//计数3
        try {

        } finally {
            lock.unlock();//解锁计数 2
        }
    }
}
