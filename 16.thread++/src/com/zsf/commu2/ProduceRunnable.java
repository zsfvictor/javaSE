package com.zsf.commu2;

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
        int i = 0;
        while (true){
            //生产一个商品
            factory.produce("商品"+i);
            i++;
        }

    }
}
