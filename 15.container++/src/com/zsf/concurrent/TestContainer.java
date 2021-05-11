package com.zsf.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class TestContainer {
    public static void main(String[] args) {
        //第一代 同步方法锁，效率低下
        Vector v = new Vector();

        //第二代  同步代码块锁 效率提升有限
        List arrayList = new ArrayList();
        arrayList = Collections.synchronizedList(arrayList);

        //第三代
        ConcurrentHashMap chm;
        CopyOnWriteArrayList coal;
        CopyOnWriteArraySet cwas;
        CopyOnWriteArrayList cowal = new CopyOnWriteArrayList();
        cowal.add(null);
    }
}
