package com.zsf.map;

import com.zsf.set.Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 使用map储存学号和学生的映射
 */
public class TestMap2 {
    public static void main(String[] args) {
        //1.创建map对象
        Map <Integer,Student>map = new HashMap<Integer, Student>();
        //2.添加键值对
        Student stu1 = new Student(1,"zhangsan",23,80);
        Student stu2 = new Student(2,"lisi",24,82);
        Student stu3 = new Student(3,"wangwu",22,80);
        Student stu4 = new Student(4,"zhaoliu",23,89);
        Student stu5 = new Student(1,"zhangsan",23,80);
        map.put(stu1.getSno(),stu1);
        map.put(stu2.getSno(),stu2);
        map.put(stu3.getSno(),stu3);
        map.put(stu4.getSno(),stu4);
        map.put(stu5.getSno(),stu5);
        //3.遍历输出
        System.out.println(map.size());
        System.out.println(map.get(3));//不是索引，是内容
        Set<Map.Entry<Integer, Student>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Student>> it = entries.iterator();
        while (it.hasNext()){
            Map.Entry<Integer, Student> entry = it.next();
            //System.out.println(entry);
            Student stu = entry.getValue();
            System.out.println(stu);
        }
        //4.其他方法
    }
}
