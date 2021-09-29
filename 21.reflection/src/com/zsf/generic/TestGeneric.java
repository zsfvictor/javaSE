package com.zsf.generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;


public class TestGeneric {
  public void method1(Map<Integer,Student> map, List<Student> list, String str){

  }
  public Map<Integer,Student> method2(){
    return null;
  }

  public static void main(String[] args) throws NoSuchMethodException {
    Class testGenericClass = TestGeneric.class;
    Method M1 = testGenericClass.getMethod("method1", Map.class, List.class, String.class);
    Type [] parameterTypes = M1.getParameterTypes();
    System.out.println(parameterTypes.length);
    for (Type p:parameterTypes
    ) {
      System.out.println(p);
    }

    Type[] genericParameterTypes = M1.getGenericParameterTypes();
    for (int i = 0; i < genericParameterTypes.length; i++) {
      System.out.println(genericParameterTypes[i]);

      if (genericParameterTypes[i] instanceof ParameterizedType){
        Type[] actualTypeArguments = ((ParameterizedType) genericParameterTypes[i])
            .getActualTypeArguments();
        for (Type ata:actualTypeArguments
        ) {
          System.out.println("               "+ata);
        }
      }

    }

  }
}
