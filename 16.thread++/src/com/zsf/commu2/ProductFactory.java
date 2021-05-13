package com.zsf.commu2;

import java.util.LinkedList;
import java.util.List;

/**
 * 商品的工厂类
 */
public class ProductFactory {
    //储存商品
    List<String> list = new LinkedList<String>();

    int max = 10;


    public synchronized void produce(String name) {
        //如果仓库已满，就等待
        while (list.size() == max){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //生产商品
        list.add(name);
        System.out.println(Thread.currentThread().getName() + "生产了商品" + name + "，当前商品总数" + list.size());

        //如果仓库已满，通知消费者消费
        if(list.size() == max){
            this.notifyAll();
        }
    }

    //消费商品
    public synchronized void consume() {
        //如果仓库为空，就等待
        while(list.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //消费商品
        String name = list.remove(0);
        System.out.println(Thread.currentThread().getName() + "消费了商品" + name + ",当前商品总数" + list.size());
        //如果仓库为空就通知生产者
        if (list.size() == 0){
            //this.notify();
            this.notifyAll();
        }
    }

}
