package com.zsf.map;


public class HashMap implements Map{
    transient Entry [] table;//指向哈希表的主数组的引用变量
    transient int size;//哈希表中节点的数量

    public HashMap() {
        this(11);
    }

    public HashMap(int capacity){
        table = new Entry[capacity];
    }

    /**
     * 链表中节点类
     */
    class Entry implements Map.Entry{
        final Object key;//KEY
        Object value;//VALUE
        Entry next;//下一个节点
        int hash;//key的哈希码

        Entry(int h,Object k,Object v,Entry n){
            value = v;
            next = n;
            key = k;
            hash = h;
        }
        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public String toString() {
            if (next!=null){
                return "Entry{" +
                        "key=" + key +
                        ", value=" + value +
                        ", next=" + next +
                        ", hash=" + hash +
                        '}';
            }else{
                return "Entry{" +
                        "key=" + key +
                        ", value=" + value +
                        ", hash=" + hash +
                        '}';
            }
        }
    }

    @Override
    public void put(Object key, Object value) {
        //计算key哈希码
        int hash = key.hashCode();
        //根据哈希码计算存储位置（主数组的索引）
        int index = hash%table.length;
        //存入到指定位置
        if (table[index]==null){//情况1：位置为空，直接加入
            table[index] = new Entry(hash,key,value,null);
            size++;
        }else{//如果指定位置不为空，发生了冲突，需要逐个比较
            Entry entry = table[index];//指向列表第一个节点
            while (entry!=null){
                //比较,情况2：如果找到了相同的key
                if (entry.hash == hash && (entry.key == key ||entry.getKey().equals(key))){
                    //用新的value覆盖旧value
                    entry.value = value;
                    //返回旧value
                    return;
                }
                //指向下一个节点
                entry = entry.next;
            }
            //情况3:发生了冲突，没有相同的key，添加一个新的节点做链表的首节点
            Entry  firstEntry = table[index];
            table[index] = new Entry(hash, key, value, firstEntry);
            size++;
        }
    }

    @Override
    public Object get(Object key) {


        //查找对应的entry
        Entry entry = getEntry(key);

        //返回entry中的value

        return entry == null?null:entry.getValue();
    }

    public Entry getEntry(Object key) {
        //计算hash码
        int hash = key.hashCode();

        //计算存储位置
        int index = hash % table.length;
        //查找对应的entry
        Entry entry1 = null;
        if (table[index]!=null){
            Entry currentEntry = table[index];
            while(currentEntry!=null){
                if (currentEntry.hash == hash && (currentEntry.key == key||currentEntry.key.equals(key))){
                    entry1 = currentEntry;
                    break;
                }
                currentEntry = currentEntry.next;
            }

        }
        return entry1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder("{");
        for (int i = 0; i < table.length; i++) {
            if (table[i]!=null) {
                Entry entry = table[i];//指向链表的第一个节点
                do {
                    builder.append(entry.key+"="+entry.value+",");
                    entry = entry.next;
                }while (entry!=null);
            }
            if (size>0){
                builder.deleteCharAt(builder.length()-1);
            }
        }
       builder.append("}");
       return builder.toString();
    }
}
