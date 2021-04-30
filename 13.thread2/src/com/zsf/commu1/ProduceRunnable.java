package com.zsf.commu1;

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
            if (i%2==0){
                product.setName("馒头");
                product.setColor("白色");
            }else {
                product.setName("玉米饼");
                product.setColor("黄色");
            }
            System.out.println("生产者生产一个商品:"+product.getName()+"   "+product.getColor());
            i++;
        }
    }
}
