package com.zsf.abstract1;

public abstract class Animal {
    private String color;

    public Animal(String color) {
        this.color = color;
    }

    public Animal() {
    }

/*    public void shout(){
        System.out.println("----叫----");
    }*/

    public abstract void shout();
}
