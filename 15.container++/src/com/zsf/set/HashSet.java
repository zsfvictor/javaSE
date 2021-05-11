package com.zsf.set;

import com.zsf.map.HashMap;

public class HashSet implements Set {

    private HashMap map;
    private static final Object PRESENT = new Object();

    public HashSet(){
        map = new HashMap();
    }
    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void add(Object obj) {
        //map.put(obj,new Object());
        map.put(obj,PRESENT);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object obj) {
        return map.getEntry(obj) != null;
    }
}
