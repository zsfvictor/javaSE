package com.zsf.map;


import java.util.Arrays;

public class TestHashMap {
    public static void main(String[] args) {
        java.util.HashMap map2;
        HashMap map = new HashMap();
        map.put(23,"China");
        map.put(36,"Japan");
        map.put(48,"America");
        map.put(86,"the United States");
        map.put(67,"France");
        map.put(23,"Italian");
        map.put(47,"England");
        System.out.println(map.size());
        System.out.println(Arrays.toString(map.table));
        System.out.println(map.get(23));
        System.out.println(map);
    }
}
