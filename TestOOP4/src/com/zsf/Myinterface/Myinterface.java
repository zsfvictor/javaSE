package com.zsf.Myinterface;

public interface Myinterface {
    //全局静态常量没有变化

    //变化：可以有非抽象方法

    //1.抽象方法:子类必须实现
    public abstract void method1();
    //2.非抽象方法1：static修饰   不能被实现类重写，只能通过类名调用
    public static void method2(){
        System.out.println("---------interface static method2-------");

    }
    //3.非抽象方法2：default修饰,类可以继承也可以重写，只能通过对象名调用
    //如果重写，要实现类里必须去掉default关键字
    public default void method3(){
        System.out.println("----interface default method------");
    }
}
