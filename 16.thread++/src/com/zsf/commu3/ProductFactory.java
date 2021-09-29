package com.zsf.commu3;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 商品的工厂类
 */
public class ProductFactory {
    //储存商品
    List<String> list = new LinkedList<String>();

    int max = 10;

    Lock lock = new ReentrantLock();
    Condition produceCondition = lock.newCondition();
    Condition consumeCondition = lock.newCondition();

    public ProductFactory() {
    }


    public void produce(String name) {
        lock.lock();
        try {
            //如果仓库已满，就等待
            while (list.size() == max) {
                try {
                    //this.wait();
                    produceCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //生产商品
            list.add(name);
            System.out.println(Thread.currentThread().getName() + "生产了商品" + name + "，当前商品总数" + list.size());

            //只要生产，通知消费者消费
            consumeCondition.signal();
        } finally {
            lock.unlock();
        }

    }

    //消费商品
    public void consume() {
        lock.lock();
        try {
            //如果仓库为空，就等待
            while (list.size() == 0) {
                try {
                    //this.wait();
                    consumeCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //消费商品
            String name = list.remove(0);
            System.out.println(Thread.currentThread().getName() + "消费了商品" + name + ",当前商品总数" + list.size());
            //如果消费了就通知生产者
            produceCondition.signal();
        } finally {
            lock.unlock();
        }

    }

}
