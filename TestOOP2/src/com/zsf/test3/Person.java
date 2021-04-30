package com.zsf.test3;

public class Person {
    private int age;
    private String name;
    private double height;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void  eat(){
        System.out.println("吃饭");
    }

    public void  sleep(){
        System.out.println("睡觉");
    }

}
