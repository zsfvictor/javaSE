package com.zsf.commu3;

/**
 * 消费者线程
 */
public class ConsumeRunnable implements Runnable{
    //private Product product = new Product();
    private Product product;

    public ConsumeRunnable() {
    }

    public ConsumeRunnable(Product product) {
        this.product = product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true){
            //消费者和生产者都要加锁，而且是同一把锁
            synchronized (product){
                //1.如果没有商品就等待
                if (!product.flag){
                    try {
                        product.wait();//让CPU也让锁
                        //.sleep是让CPU不让锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //2.有商品就消费
                System.out.println("消费者消费一个产品"+product.getName()+"   "+product.getColor());
                //3.改变商品状态有无
                product.flag = false;
                //4.通知生产者生产
                product.notify();//随机唤醒一个线程
            }
        }
    }
}
