package com.zsf.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollection {

  public static void main(String[] args) {
    //1.添加元素
    ArrayList<Integer> list = new ArrayList<>();
    System.out.println(list);
    Collections.addAll(list, 1, 8, 3, 4, 2, 6, 7);
    System.out.println(list);
    //2.排序
    Collections.sort(list);
    System.out.println(list);
    //3.查找
    int index = Collections.binarySearch(list, 2);
    System.out.println(index);

    //4.最大值最小值
    Integer max = Collections.max(list);
    Integer min = Collections.min(list);
    System.out.println(max + "   " + min);
    //6.填充
    Collections.fill(list, 100);
    System.out.println(list);
    //7.复制
    List list2 = new ArrayList();
    Collections.addAll(list2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    System.out.println(list2);
    Collections.copy(list2, list);
    System.out.println(list2);
    //8.同步

  }
}
