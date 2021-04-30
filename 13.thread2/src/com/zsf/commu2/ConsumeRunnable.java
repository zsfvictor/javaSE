package com.zsf.commu2;

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
                System.out.println("消费者消费一个产品"+product.getName()+"   "+product.getColor());
            }
        }
    }
}
