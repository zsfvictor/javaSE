package com.zsf.list3;

public class SingleLinkedList implements List{

    private  Node head = new Node();//实现存在一个头节点

    private int size;//节点数量,默认为0，不包括头结点


    @Override
    public int size() {
        return size;
    }

    @Override
    public Node get(int i) {
        //判断
        if (i<0 || i>size){
            throw new IndexOutOfBoundsException("数组指针越界"+i);
        }
        //定义一个P指向头结点
        Node p = head;

        //循环i次找到i节点
        for (int j = 0; j <= i; j++) {
            p = p.next;//指向下一个节点
        }
        //返回第i个节点
        return p;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object e) {
        return indexOf(e)>=0;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public void add(int i, Object e) {
        //先获取第i-1个元素(如果i=0，就是获取头节点)
        Node p = head;
        if (i>0){
            p = get(i-1);
        }
        //新建一个节点并加入数据
        Node newNode = new Node(e);
        //指定新节点的下一个节点
        newNode.next = p.next;
        //前一个节点的下一个节点是当前的新节点
        p.next = newNode;
        //节点数量+1
        size++;
    }

    @Override
    public void add(Object e) {
        add(size,e);
    }

    @Override
    public void addBefore(Object obj, Object e) {

    }

    @Override
    public void addAfter(Object obj, Object e) {

    }

    @Override
    public Object remove(int i) {
        //先获取第i-1个元素（如果i=0，就是获取头结点）
        Node p = head;
        if (i>0){
            p = get(i-1);

        }
        //指向当前i节点
        Node currNode = p.next;
        // 第i-1个节点的下一个节点是i+1节点
        p.next = p.next.next;
        //第i个节点没有下一个节点
        currNode = null;
        //节点-1
        size--;
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

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder("[");
        /*
        for (int i = 0; i < size; i++) {
            Node node = get(i);
            build.append(node.data).append(",");
        }
        */
        Node p = head;
        for (int i = 0;i<size;i++){
            p = p.next;
            build.append(p.data+",");
        }
        if (size !=0){
            build.deleteCharAt(build.length()-1);
        }
        build.append("]");
        return build.toString();
    }
}
