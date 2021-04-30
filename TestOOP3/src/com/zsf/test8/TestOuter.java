package com.zsf.test8;

public class TestOuter {
    //1.局部内部类中，访问到的变量，必须被final修饰
    public void method(){
        final int num = 10;
        class A {
            public void a(){
                //num = 20;
                System.out.println(num);
            }
        }
    }
    //如果类B在整个项目中只使用一次，那么就没有必要单独创建一个类B，使用内部类就可以
    public Comparable method2(){
        class B implements Comparable{
            @Override
            public int compareTo(Object o) {
                return 100;
            }
        }
        return new B();
    }

    public Comparable method3(){
        //匿名内部类
        return new Comparable(){

            @Override
            public int compareTo(Object o) {
                return 200;
            }
        };
    }

    public void test(){
        Comparable com = new Comparable() {
            //匿名内部类
            @Override
            public int compareTo(Object o) {
                return 200;
            }
        };

        System.out.println(com.compareTo("abc"));
    }
}
