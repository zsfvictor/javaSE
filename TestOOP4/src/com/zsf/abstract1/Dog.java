package com.zsf.abstract1;

public class Dog extends Animal {
    private int age;

    public Dog() {
    }

    public void shout(){
        System.out.println("------旺-----");
    }

    public static void main(String[] args) {
        //Animal an = new Animal();  抽象类不能实例化

        Dog d = new Dog();
        d.shout();
    }
}
