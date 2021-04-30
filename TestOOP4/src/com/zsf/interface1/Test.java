package com.zsf.interface1;

public class Test {
    public static void main(String[] args) {
        Bird bird = new Bird();
        fly(bird);

        Plane plane = new Plane();
        fly(plane);

        Flyable sm = new SuperMan();
        fly(sm);
    }

    public static void fly(Flyable flyable){
        flyable.fly();
    }
}
