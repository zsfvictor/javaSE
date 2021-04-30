package com.zsf.test7;

public class Demo {
    public static void main(String[] args) {
        //创建外部类对象
        TestOuter to = new TestOuter();
        to.a();

        //创建内部类的对象

        //静态的成员内部类创建对象： new+外部类.内部类
        TestOuter.e e1 = new TestOuter.e();

        //非静态的成员内部类
        //错误： TestOuter.d d1 = new TestOuter.d();
        TestOuter T = new TestOuter();
        TestOuter.d d1 = T.new d();
    }
}
