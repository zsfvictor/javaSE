package com.zsf.generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;


public class TestGeneric2 {
  public void method1(Map<Integer,Student> map, List<Student> list, String str){

  }
  public Map<Integer,Student> method2(){
    return null;
  }

  public static void main(String[] args) throws NoSuchMethodException {
    Class testGenericClass = TestGeneric2.class;

    //获取返回值（不带泛型）
    Method M2 = testGenericClass.getMethod("method2");
    Class<?> returnType = M2.getReturnType();
    System.out.println(returnType);

    //获取返回值的类型（带泛型）
    Type genericReturnType = M2.getGenericReturnType();
    System.out.println(genericReturnType);

    Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
    for (Type actualTypeArgument : actualTypeArguments){
      System.out.println("        "+actualTypeArgument);
    }
  }
}
