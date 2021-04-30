package com.zsf.synch1;

/**
 * 银行账户类
 *
 */
public class Account {
    private int balance = 600;//余额

    /**
     * 取款
     * @param money
     */
    public void withDraw(int money){
        this.balance = this.balance - money;
    }

    /**
     * 查看余额
     *
     * @return
     */
    public int getbalance(){
        return balance;
    }
}
