package com.zsf.set;

import java.util.HashSet;

public class TestHashSet {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("JavaSE");
        set.add("MySQL");
        set.add("JavaScript");
        set.add("jQuery");
        set.add("JavaSE");

        System.out.println(set.size());
        System.out.println(set.contains("JavaSE"));
        System.out.println(set);
    }
}
