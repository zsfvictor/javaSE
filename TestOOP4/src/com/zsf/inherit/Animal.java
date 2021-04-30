package com.zsf.inherit;

public class Animal {
    private String color;
    private int age;

    public Animal() {
    }

    public Animal(String color, int age) {
        this.color = color;
        this.age = age;
    }

    public void eat(){
        System.out.println("吃");
    }

    public void cry(){
        System.out.println("叫");
    }

    public void introduce(){
        System.out.println("颜色："+color+"年龄："+age);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
