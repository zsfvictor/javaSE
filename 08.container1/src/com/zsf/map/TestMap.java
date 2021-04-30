package com.zsf.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用各种map储存国家简称和国家名称之间的映射
 */
public class TestMap {
    public static void main(String[] args) {
        //创建一个map对象
        Map<String,String> map = new HashMap<String,String>();

        //向map对象中添加键值对
        map.put("cn","China");
        map.put("jp","Japan");
        map.put("us","the United States");
        map.put("fr","France");
        map.put("us","America");
        map.put("uk","the United Kingdom");
        map.put("ek","the United Kingdom");
        //输出内容
        System.out.println(map);
        System.out.println(map.size());
    }
}
