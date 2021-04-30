package com.zsf.synch0;

/**
 * 取款的线程
 */
public class AccountRunnable implements Runnable{
    private Account account = new Account();
    /**
     * 线程体：取款的步骤
     */
    @Override
    public void run() {
        if (account.getbalance()>=400){//余额足够就取款
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.withDraw(400);
            System.out.println(Thread.currentThread().getName()+"取款成功，当前余额："+account.getbalance());
        }else {
            //余额不足，给提示
            System.out.println(Thread.currentThread().getName()+"取款失败，余额不足，当前余额："+account.getbalance());
        }
    }
}
