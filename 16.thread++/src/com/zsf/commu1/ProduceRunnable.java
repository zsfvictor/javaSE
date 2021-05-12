package com.zsf.commu1;

/**
 * 生产者线程
 */
public class ProduceRunnable implements Runnable{

    private ProductFactory factory;

    public ProduceRunnable() {
    }

    public ProduceRunnable(ProductFactory factory) {
        this.factory = factory;
    }

    public void setFactory(ProductFactory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        while (true){
            //生产一个商品
            factory.produce();
        }

    }
}
