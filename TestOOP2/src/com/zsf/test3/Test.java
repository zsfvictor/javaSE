package com.zsf.test3;

public class Test {
    public static void main(String[] args) {
        Student s = new Student();
        s.setSno(56);
        s.setAge(18);
        s.setHeight(167.3);
        s.setName("lili");

        System.out.println(s.getSno()+"\t"+s.getAge()+"\t"+s.getHeight()+"\t"+s.getName());

        //方法“
        s.study();
        s.eat();
        s.sleep();
        s.hashCode();

    }
}
