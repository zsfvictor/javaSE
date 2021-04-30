package com.zsf.generic;

/**
 * 泛型类
 * @param <E>
 */
public class ArrayList<E> implements List<E>{
    private E elem;

    @Override
    public void add(E obj) {
        this.elem = elem;
    }

    @Override
    public E get(int index) {
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Student> list1 = new ArrayList<Student>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
    }
}
