package com.zsf.commu1;

public class Test {
    public static void main(String[] args) {
        Product product = new Product();
        //创建2个线程对线
        Runnable runnable1 = new ProduceRunnable(product);
        ConsumeRunnable runnable2 = new ConsumeRunnable();
         runnable2.setProduct(product);
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        //启动线程
        thread1.start();
        thread2.start();
    }
}
