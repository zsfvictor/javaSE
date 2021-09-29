package com.zsf.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class TestClass1 {

  public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
    //获取一个类的类对象，Class信息
    Class clazz = Class.forName("com.zsf.why.Dog");

    //2.从类对象中获取具体的结构信息： get
    //2.1获取基本的信息
    System.out.println(clazz.getName());//com.zsf.why.Dog
    System.out.println(Arrays.toString(clazz.getInterfaces()));//[interface java.io.Serializable, interface java.lang.Cloneable]
    System.out.println(clazz.getSuperclass());//父类的类对象 class com.zsf.why.Animal
    System.out.println(clazz.getSimpleName());//Dog
    System.out.println(clazz.getModifiers());//17
    System.out.println(Modifier.toString(clazz.getModifiers()));//public final

    //2.2获取成员变量
    //Field[] fields = clazz.getFields();//获取所有的public属性，包括上级类的
    Field[] fields = clazz.getDeclaredFields();//获取所有的属性，但是不包括上级类
    for (Field f :
        fields) {
      System.out.println(f);
    }
    System.out.println("===============");
    Field f = clazz.getField("type");
    System.out.println(f);
    //2.3获取成员方法

    //2.4获取构造方法
  }
}
