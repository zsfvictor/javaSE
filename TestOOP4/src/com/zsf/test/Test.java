package com.zsf.test;

public class Test {
    public static void main(String[] args) {
        Fish fi = new Fish(1, 2.3);
        fi.swim();
        fi.introduce();
        giveInstroduce(fi);
    }

    public static void giveInstroduce(Animal an){
        an.introduce();
    }
}
