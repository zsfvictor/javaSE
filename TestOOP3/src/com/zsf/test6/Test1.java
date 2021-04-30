package com.zsf.test6;
/*
 类和接口是并列概念
 接口中没有构造器
 接口如何声明：interface
 在JDK1.8之前，接口只有2部分内容：
  常量：固定修饰符：public static final
  抽象方法：固定修饰符：public abstract
 */

public interface Test1 {//public abstract 和public static final可以省略不写
    //常量：
    /*public static final*/ int NUM = 10;
    //抽象方法：
    /*public abstract*/ void a();
    /*public abstract*/ void b(int num);
    /*public abstract*/ int c(String name);

}
/*
类和接口的关系：实现关系   类实现接口
一旦实现一个接口，实现类要重写接口中的全部的抽象方

 */
