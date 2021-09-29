package com.zsf.commu4;


/**
 * 测试类
 *
 * 功能：拓展生产者消费者问题
 * 由一个生产者、一个消费者、一个商品扩展为多个生产者、多个消费者、多个商品。
 * 具体细节为最多10个商品,最少0个商品
 * 已经有10个商品，生产者不再生产，还要通知消费者消费
 * 没有商品了，消费者不再消费，还要通知生产者生产
 */
public class Test {
    public static void main(String[] args) {
        ProductFactory productFactory = new ProductFactory();
        //创建10个生产者者线程并启动
        //Runnable runnable1 = new ProduceRunnable(productFactory);
        Runnable runnable1 = () -> {
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //生产一个商品
                productFactory.produce("商品" + i);
                i++;
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(runnable1,"生产者"+i).start();
        }
        // 创建20个消费者线程并启动
        //Runnable runnable2 = new ConsumeRunnable(productFactory);
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                //消费一个商品
                while (true){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    productFactory.consume();

                }
            }
        };
        for (int i = 0; i < 20; i++) {
            new Thread(runnable2,"消费者"+i).start();
        }
    }
}
