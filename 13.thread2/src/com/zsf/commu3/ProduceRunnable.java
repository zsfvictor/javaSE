package com.zsf.commu3;

/**
 * 生产者线程
 */
public class ProduceRunnable implements Runnable{
    //private Product product = new Product();
    private Product product;

    public ProduceRunnable() {
    }

    public ProduceRunnable(Product product) {
        this.product = product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            synchronized (product){
                //1.判断是否有商品，有商品则不生产，等待
                if (product.flag){
                    try {
                        product.wait();//sleep会释放CPU不释放锁，wait会释放锁又释放CPU
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //2.没有商品，生产商品
                if (i%2==0){
                    product.setName("馒头");
                    product.setColor("白色");
                }else {
                    product.setName("玉米饼");
                    product.setColor("黄色");
                }
                System.out.println("生产者生产一个商品:"+product.getName()+"   "+product.getColor());
                //3.改变商品有无的状态：有商品了
                product.flag = true;
                //4.通知消费
                product.notify();
            }
            i++;
        }
    }
}
