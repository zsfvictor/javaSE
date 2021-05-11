package com.zsf.list3;


public class LinkedList implements List{

    transient int size = 0;//有几个节点

    transient Node first;//指向列表的第一个节点

    transient Node last;//指向列表的最后一个节点

    /**
     * 内部类，表示LinkedList的节点
     * @param <E>
     */
    private static class Node<E> {
        E item;//数据
        Node<E> next;//指向下一个节点
        Node<E> prev;//指向前一个节点

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        return node(i).item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        return false;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public void add(int index, Object element) {

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }

    /**
     * 查询指定索引的节点
     * @param index
     * @return
     */
    Node node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public void add(Object e) {
        linkLast(e);
    }

    void linkLast(Object e) {
        final Node l = last;
        final Node newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;

    }

    void linkBefore(Object e, Node succ) {
        // assert succ != null;
        final Node pred = succ.prev;
        final Node newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;

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
        return null;
    }
}
