package com.zsf.list;

import java.util.ArrayList;
import java.util.Iterator;

public class TestArrayList2 {
    public static void main(String[] args) {
        //1.创建一个ArrayList对象，存储多个分数
        ArrayList arlst = new ArrayList();

        //2.添加元素
        arlst.add(67);
        arlst.add(88);
        arlst.add(90);
        arlst.add(77);
        arlst.add(88);
        arlst.add(2,100);
        //3.获取集合的内容
        System.out.println(arlst.toString());
        System.out.println(arlst.size());
        System.out.println(arlst.get(2));
        System.out.println();
        //4.遍历，用for
        for (int i = 0; i < arlst.size(); i++) {
            int elem = (int) arlst.get(i);
            System.out.println(elem);
        }
        System.out.println();
        //5.遍历，用for-each
        for (Object elem :
                arlst) {
            System.out.println(elem);
        }
        System.out.println();
        //6.使用迭代器遍历
        Iterator it = arlst.iterator();
        while (it.hasNext()){
            Integer elem = (Integer) it.next();
            System.out.println(elem);
        }
    }
}
