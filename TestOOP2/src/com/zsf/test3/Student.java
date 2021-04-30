package com.zsf.test3;

public class Student extends Person {//子类Student继承父类Person
        //只定义特殊属性
    private int sno;//学号

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }
    //方法：
    public void study(){
        System.out.println("学习");
    }
}
