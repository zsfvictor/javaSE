package com.zsf.commu5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 商品类
 */
public class Product {
    private String name;//名称，馒头，玉米饼
    private String color;//颜色，白色，黄色
    boolean flag = false;//默认没有商品

    private Lock lock = new ReentrantLock();
    private Condition produceCondition = lock.newCondition();
    private Condition consumeCondition = lock.newCondition();



    public Product() {
    }

    public Product(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    /**
     *  生产一个商品
     */
    public void produce(int i){//锁为this
        lock.lock();
        try {
            //1.判断是否有商品，有商品则不生产，等待
            if (flag){
                try {
                    //wait();//sleep会释放CPU不释放锁，wait会释放锁又释放CPU
                    produceCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //2.没有商品，生产商品
            if (i%2==0){
                //product.setName("馒头");
                this.name = "馒头";
                //product.setColor("白色");
                color = "白色";
            }else {
                //product.setName("玉米饼");
                this.name = "玉米饼";
                // product.setColor("黄色");
                color = "黄色";
            }
            System.out.println("生产者生产一个商品:"+name+"   "+color);
            //3.改变商品有无的状态：有商品了
            flag = true;
            //4.通知消费
            //notify();
            consumeCondition.signalAll();
        }finally {
            lock.unlock();
        }



    }

    /**
     * 消费一个商品
     */
    public void consume(){//this
        lock.lock();
        try {
            //1.如果没有商品就等待
            if (!flag){
                try {
                    //this.wait();//让CPU也让锁
                    wait();
                    //.sleep是让CPU不让锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //2.有商品就消费
            System.out.println("消费者消费一个产品"+name+"   "+color);
            //3.改变商品状态有无
            flag = false;
            //4.通知生产者生产
            //this.notify();//随机唤醒一个线程
            //notify();
            consumeCondition.signalAll();
        }finally {
            lock.unlock();
        }


    }
}
