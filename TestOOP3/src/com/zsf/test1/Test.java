package com.zsf.test1;

public class Test {
    public static void main(String[] args) {
        Student s = new Student(19,167.4,"lili");
        s.setAge(10);
        System.out.println(s.getAge());
        System.out.println(s);//com.zsf.test1.Student@1b6d3586
        System.out.println(s.toString());//com.zsf.test1.Student@1b6d3586
    }
}
