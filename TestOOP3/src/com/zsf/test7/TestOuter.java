package com.zsf.test7;

/*
类的组成：属性，方法，构造器，代码块(普通块，静态块，构造块，同步块)，内部类
一个类（TestOut）的内部的类（SubTest）叫做内部类， 内部类：SubTest  外部类：TestOut
内部类：成员内部类 (静态的，非静态的)和 局部内部类(位置:方法内，块内，构造器内)
成员内部类：
    里面可以有属性，方法，构造器等
    修饰符：private,default,protect,public,final,abstract
*/

public class TestOuter {
    //成员内部类：
    class d{
        int age = 20;
        String name;
        public void method(){
            //内部类可以访问外部类内容
/*            System.out.println(age);
            a();*/
            int age = 30;
            //内部类和外部类属性重名的时候如何调用
            System.out.println(age);//30
            System.out.println(this.age);//20
            System.out.println(TestOuter.this.age);//10
        }
    }
    //静态成员内部类:"
    static class e{
        public void method(){
            //静态内部类中，只能访问外部类中被static修饰的内容
            /*System.out.println(age);
            a();*/
        }
    }
    //属性：
    int age = 10;

    //方法：
    public void a(){
        System.out.println("111111a11111");
        {
            System.out.println("普通块");
            class B{//局部内部类

            }
        }
        class A{//局部内部类

        }
        //外部类要访问内部类的东西，需要创建内部类的对象，然后进行调用
        d d1 = new d();
        System.out.println(d1.name);
        d1.method();
    }
    static {
        System.out.println("静态块");
    }
    {
        System.out.println("构造块");
    }
    //构造器：
    public TestOuter(){
        class c{//局部内部类

        }
    }

    public TestOuter(int age) {
        this.age = age;
    }
}
