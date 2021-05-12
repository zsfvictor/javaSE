package com.zsf.commu1;

/**
 * 消费者线程
 */
public class ConsumeRunnable implements Runnable{
    private ProductFactory factory;

    public ConsumeRunnable() {
    }

    public ConsumeRunnable(ProductFactory factory) {
        this.factory = factory;
    }

    public void setFactory(ProductFactory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        int i = 0;
        //消费一个商品
        while (true){
            factory.consume("商品"+i);
            i++;
        }
    }
}
