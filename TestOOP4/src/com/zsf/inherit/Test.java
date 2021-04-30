package com.zsf.inherit;

public class Test {
    public static void main(String[] args) {
        Dog d = new Dog("花色", 10, "旺财");
        d.introduce();
        d.getGruand();
        d.cry();
        d.eat();
        int a = d.getAge();
        System.out.println(a);

    }
}
