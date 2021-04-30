package com.zsf.test;

import java.util.Objects;

public class Fish extends Animal{
    private double weight;

    public Fish() {
    }

    public Fish(double weight) {
        this.weight = weight;
    }

    public Fish(int age, double weight) {
        super(age);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "weight=" + weight +"age"+super.getAge()+
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fish fish = (Fish) o;
        return Double.compare(fish.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }
    public void swim(){
        System.out.println("能游");
    }

    public void introduce(){
        System.out.println("我是"+weight+"斤重的鱼");
    }
}
