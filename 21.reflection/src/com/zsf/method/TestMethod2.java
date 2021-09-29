package com.zsf.method;

import java.lang.reflect.Method;

/**
 * 使用反射
 * 1.动态的创建对象 newInstance()
 * 2.动态的操作属性 set() get()
 * 3.动态的执行方法  invoke()
 *
 * 实际开发中动态操作属性不多，更多是动态执行方法
 *
 * 使用反射执行方法，不一定必须通过反射创建对象
 *
 * 但是如果通过反射来创建对象，一般都要通过反射来执行方法 
 *
 */

public class TestMethod2 {
  public void shout(){
    System.out.println("-------shout------");
  }

  public int add(int num1,int num2){
    return num1+num2;
  }


  public static void main(String[] args) throws Exception{
    //不使用反射执行方法
    TestMethod2 testMethod = new TestMethod2();



    //2.獲取類的類對象
    Class clazz = testMethod.getClass();

    //4.从类对象中获取方法
    Method M1 = clazz.getMethod("shout");
    Method M2 = clazz.getMethod("add",int.class,int.class);
    //5.使用反射执行方法
    M1.invoke(testMethod);
    Object value = M2.invoke(testMethod,10,20);//int intrsult = testMethod.add(10, 20);
    System.out.println(value);

  }
}
