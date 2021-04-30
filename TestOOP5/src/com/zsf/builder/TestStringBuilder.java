package com.zsf.builder;

public class TestStringBuilder {
    /**
     * stringbuilder
     * @param args
     * 常用操作
     *  StringBuilder strb = new StringBuilder("中华人民共和国");
     *   strb.append("北京市");
     *   String str = strb.toString();
     */
    public static void main(String[] args) {
        //1.创建一个StringBuilder对象
        //StringBuilder strb = new StringBuilder();
        StringBuilder strb = new StringBuilder("中华人民共和国");

        //2.对StringBuilder进行操作

        //2.1末尾追加
        strb.append("北京市");
        strb.append("大兴区") ;
        strb.append("亦庄开发区");
        strb.append("北京尚学堂");
        System.out.println(strb);

        //2.5反转
        strb.reverse();
        //2.6 StringBuilder ==>String
        String str = strb.toString();
        System.out.println(str);
        System.out.println(strb.equals(str));


    }
}
