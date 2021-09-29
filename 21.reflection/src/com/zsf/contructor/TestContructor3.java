package com.zsf.contructor;

import com.zsf.why.Dog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用反射调用有参构造方法创建对象
 *
 * 只有一种方式：
 * 通过constructor 的newInstance()
 */
public class TestContructor3 {

  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    //不使用反射创建对象
    Dog dog = new Dog("旺财", 4, "刘宏宇狗");
    System.out.println(dog);

    //使用反射创建对象
    //1.获取类的完整路径字符串（properties、DOM4J）
    String className = "com.zsf.why.Dog";
    //2.根据完整路径字符串获取类的类对象
    Class clazz = Class.forName(className);
    //3.从类对象中获取有参构造方法
    //Constructor cons = clazz.getConstructor(String.class,int.class,String.class);
    Constructor cons = clazz.getDeclaredConstructor(String.class,int.class,String.class);
    //4.使用反射
    cons.setAccessible(true);//突破限制
    Object obj = cons.newInstance("刘宏宇",4,"刘宏宇犬");

    System.out.println(obj);

  }
}
