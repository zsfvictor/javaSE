package com.zsf.list;




public class TestArrayList {
    public static void main(String[] args) {
        java.util.List list2 = new java.util.ArrayList();
        //创建线性序列表
        ArrayList list = new ArrayList();
        //向末尾添加元素
        list.add("111111");
        list.add("aaaaaa");
        list.add("bbbbbb");
        list.add("333333");
        list.add("22222");
        list.add(3,"AAAAAAAA");
        //通过各种操作验证添加
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(2));
        System.out.println(list.contains("4444444"));
        System.out.println(list.indexOf("22222"));
        System.out.println(list.toString());
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String elem = it.next();
            System.out.println(elem);
        }

    }
}
