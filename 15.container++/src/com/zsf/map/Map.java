package com.zsf.map;

public interface Map {
    void put(Object kye,Object vallue);
    Object get(Object key);
    int size();
    boolean isEmpty();

    interface Entry{
        Object getKey();
        Object getValue();

    }
}
