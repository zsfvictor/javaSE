package com.zsf.contructor;

import com.zsf.why.Dog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用反射调用无参构造方法创建对象
 *
 * 方法1：调用constructor的newInstance()
 * 方法2: 调用class的newInstance（）
 *
 */
public class TestContructor1 {

  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    //不使用反射创建对象
    //Dog dog = new Dog();

    //使用反射创建对象
    //1.获取类的完整路径字符串（properties、DOM4J）
    String className = "com.zsf.why.Dog";
    //2.根据完整路径字符串获取类的类对象
    Class clazz = Class.forName(className);
//    //3.从类对象中获取无参构造方法
//    Constructor cons = clazz.getConstructor();
//    //4.使用反射
//    Object obj = cons.newInstance();

    Object obj = clazz.newInstance();

  }
}
