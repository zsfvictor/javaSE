package com.zsf3;

public class MsbStudent {
    String name;
    int age;
    static String school;

    public static void main(String[] args) {
        MsbStudent.school = "马士兵教育";

        MsbStudent s1 = new MsbStudent();
        s1.name = "张三";
        s1.age = 19;
        MsbStudent s2 = new MsbStudent();
        s2.name = "李四";
        s2.age = 20;
        MsbStudent s3 = new MsbStudent();
        s3.name = "王五";
        s3.age = 18;

        System.out.println(s3.school);
        System.out.println(MsbStudent.school);
    }
}
