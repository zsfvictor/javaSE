package com.zsf.generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.反射的强大之处
 * 2.使用反射执行方法，不一定要通过反射创建对象
 */
public class TestGeneric3 {

  public static void main(String[] args)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    List<Integer> list = new ArrayList<Integer>();
    list.add(123);
    list.add(456);
    list.add(789);

    System.out.println(list);

    Class<? extends List> Clazz = list.getClass();
    Method M1 = Clazz.getMethod("add", Object.class);
    M1.invoke(list,true);
    M1.invoke(list,"xxxxx");
    M1.invoke(list,3.14);
    System.out.println(list);

  }

}
