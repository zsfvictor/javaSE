package com.zsf.field;

import com.zsf.why.Dog;

public class TestField {

  public static void main(String[] args)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    //不使用反射操作属性
    //Dog dog = new Dog();

    //使用反射操作属性
    //1.获取类的完整路径字符串
    String className = "com.zsf.why.Dog";
    //2.得到类的类对象
    Class clazz = Class.forName(className);
    //3.使用反射创建对象
    Object obj = clazz.newInstance();
    //System.out.println(obj);

    //4.从Class中获取属性


    //5.使用反射操作属性

  }

}
