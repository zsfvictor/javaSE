package com.zsf.Myinterface;

public class MyClass implements Myinterface{
    public void method1(){

    }
    public void method3(){
        System.out.println("----MyClass default method------");
    }

    public static void main(String[] args) {
        Myinterface.method2();
        MyClass mc = new MyClass();
        mc.method3();
        Myinterface.method2();
    }
}
