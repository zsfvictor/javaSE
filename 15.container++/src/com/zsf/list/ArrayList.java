package com.zsf.list;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

public class ArrayList implements List{

    public transient Object [] elementData;//ArrayList底层是一个长度可以动态增长的数组

    public int size;//集合中元素的个数，不是数组空间的容量length. 增加删除元素时size要变化

    public ArrayList(){
        this(10);
    }

    public ArrayList(int i) {
        elementData = new Object[i];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if (i>=size||i<0){
            throw new IndexOutOfBoundsException("数组索引越界："+i);
        }
        return elementData[i];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        return indexOf(e)>=0;
    }

    @Override
    public int indexOf(Object e) {
        int index = -1;
        if (e==null){
            for (int i = 0; i < size; i++) {
                if (e == elementData[i]){
                    index = i;
                    break;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (e.equals(elementData[i])){
                    index = i;
                    break;
                }
            }
        }

        return index;
    }

    @Override
    public void add(int index, Object e) {
        //如果数组已满，需要先扩容
        if (elementData.length == size){
            grow();
        }
        //从后向前移动元素一个位置
        for (int i = size;i>index;i--){
            elementData[i] = elementData[i-1];
        }
        //将元素加到第i个位置
        elementData[index] = e;
        size++;
    }

    @Override
    public void add(Object e) {
        //如果数组已满，需要先扩容
        if (elementData.length == size){
            grow();
        }
        //将元素加到最后
        elementData[size] = e;
        size++;
    }

    private void grow() {
 /*       //1.新创建一个容量更大的数组
        //Object [] newarr = new Object[elementData.length*2];
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity>>1);
        Object [] newarr = new Object[newCapacity];
        //2.将原来的元素拷贝到新数组中，索引对应
        for (int i = 0; i < elementData.length; i++) {
            newarr[i] = elementData[i];
        }
        //3.成员变量elementdata指向扩容后的新数组
        elementData = newarr;*/
        elementData = Arrays.copyOf(elementData,elementData.length*2);
    }

    @Override
    public void addBefore(Object obj, Object e) {

    }

    @Override
    public void addAfter(Object obj, Object e) {

    }

    @Override
    public Object remove(int i) {
        return null;
    }

    @Override
    public boolean remove(Object e) {
        return false;
    }

    @Override
    public Object replace(int i, Object e) {
        return null;
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr();
    }

    private class Itr<T> implements Iterator<T>{
        int cursor = 0;
        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            if (cursor>=size){
                throw new RuntimeException("后续已经没有元素");
            }
            return (T) elementData[cursor++];//返回元素的同时光标移动
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(elementData[i]).append(",");
        }
        if (size>0){
            builder.deleteCharAt(builder.length()-1);
        }
        builder.append("]");
        return builder.toString();
    }
}

