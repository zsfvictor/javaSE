package com.zsf.commu4;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 商品的工厂类
 */
public class ProductFactory {
    //储存商品
//    List<String> list = new LinkedList<String>();
    ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);
    int max = 10;

    public ProductFactory() {
        blockingQueue.add(null);
        try {
            blockingQueue.put(null);
            blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        blockingQueue.offer(null);
    }

    public ProductFactory(int max) {
        this.max = max;
        blockingQueue = new ArrayBlockingQueue(max);
    }

    public void produce(String name) {

            //生产商品
        try {
            blockingQueue.put(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "生产了商品" + name + "，当前商品总数" + blockingQueue.size());

    }

    //消费商品
    public void consume() {

        //消费商品
        String name = null;
        try {
            name = blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out
            .println(Thread.currentThread().getName() + "消费了商品" + name + ",当前商品总数" + blockingQueue.size());

    }
}
