package com.zsf.inherit;

public class Dog extends Animal {
    String name;
    public Dog(){

    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String color, int age, String name) {
        super(color, age);
        this.name = name;
    }

    public void cry(){
        System.out.println("汪");
    }

    public void getGruand(){
        System.out.println("守门");
    }
}
