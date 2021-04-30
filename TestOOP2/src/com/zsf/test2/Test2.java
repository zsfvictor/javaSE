package com.zsf.test2;



public class Test2 {
    public static void main(String[] args) {
        Student S = new Student();
        S.setName("NANA");
        S.setAge(19);
        S.setSex("qqqqw");
        System.out.println(S.getSex()+"---"+ S.getName()+"----"+ S.getAge());

        Student s2 = new Student(18,"lan","男");
        System.out.println(s2.getSex()+"---"+ s2.getName()+"----"+ s2.getAge());


    }
}
