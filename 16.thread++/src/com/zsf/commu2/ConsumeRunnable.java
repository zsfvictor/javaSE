package com.zsf.commu2;

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

        //消费一个商品
        while (true){
            factory.consume();

        }
    }
}
