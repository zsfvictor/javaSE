package com.zsf2;



public class Person {
    //属性
    int age;
    String name;
    double height;
//空构造器
    public Person(){

    }
    //赋值构造器
    //构造器形参和属性重名，属性前加this即可
    public Person(int age,String name,double height){
        this.age = age;
        this.name = name;
        this.height = height;
    }

    public Person(int a,String b){
        age = a;
        name = b;
    }


    //方法
   public void eat(){
       System.out.println("11111");
   }

   public int sleep(int a,int b){
       int sum = 0;
       sum = a + b;
       return sum;
   }
}
