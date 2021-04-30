package com.zsf.test4;

public class Test {
    public static void main(String[] args) {

        final Dog d2 = new Dog();
        a(d2);

        b(d2);
    }
    public static void a(Dog d){
        d = new Dog();
    }
    public static void b(final Dog d){
        //d = new Dog();    无法修改地址
    }

}
