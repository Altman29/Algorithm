package org.example.datastructure;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表 基础实现
 * <p>
 * ！！！递归遍历！！！
 * 它是链表的一种非常重要的遍历方式
 */
public class RecursionLinkedList implements Iterable {//整体

    private Node head = null;//头节点，默认为null

    /**
     * 内部类关系，对外隐藏实现细节
     * 对外部调用者只需要LinkedList即可
     * 内部类一半都加上static
     * 节点类
     */
    private static class Node {//节点
        int value;//值
        Node next;//下一个节点

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 向链表头添加元素
     * 多理解！！
     */
    public void addFirst(int value) {
        //1.链表为空
//        head = new Node(value, null);
        //2.链表非空
        //因为head默认为null，所以不需要判断，链表空不空都能能用
        head = new Node(value, head);
    }

    /**
     * 向列表尾添加元素
     * 先找到尾节点，再添加
     */
    public void addLast(int value) {
        Node last = findLast();
        if (last == null) {
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);
    }

    /**
     * 向索引位置插入节点
     *
     * @param index 索引位置
     * @param value 待插入值
     */
    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node prev = findNode(index - 1);
        if (prev == null) {//找不到前一个节点
            throw illegalIndex();
        }
        prev.next = new Node(value, prev.next);
    }

    /**
     * 删除头节点
     */
    public void removeFirst() {
        if (head == null) {
            throw illegalIndex();
        }
        head = head.next;
    }

    /**
     * 根据索引删除节点
     */
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node prev = findNode(index - 1);
        if (prev == null) {//找不到前一个节点
            throw illegalIndex();
        }
        Node removed = prev.next;
        if (removed == null) {
            throw illegalIndex();
        }
        prev.next = removed.next;
    }

    private static IllegalArgumentException illegalIndex() {
        return new IllegalArgumentException("index illegal");
    }

    /**
     * 找到最后一个节点
     */
    private Node findLast() {
        if (head == null) {
            //链表为空，没有最后一个节点
            return null;
        }
        Node p;
        for (p = head; p.next != null; p = p.next) {
        }
        return p;
    }

    /**
     * 查询指定位置元素
     */
    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    /**
     * get方法
     */
    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw illegalIndex();
        }
        return node.value;
    }


    /**
     * 循环1 while
     */
    public void loop1(Consumer<Integer> consumer) {
        Node pointer = head;//初始值指向头节点
        while (pointer != null) {
            consumer.accept(pointer.value);//提供给外部的方法
            pointer = pointer.next;//指向下一个节点
        }
    }

    /**
     * 循环2 for
     */
    public void loop2(Consumer<Integer> consumer) {
        for (Node pointer = head; pointer != null; pointer = pointer.next) {
            consumer.accept(pointer.value);//提供给外部的方法
        }
    }

    /**
     * 循环3 iterator
     */
    @Override
    public Iterator iterator() {
        /**
         * 匿名内部类 -> 带名字的内部类
         * 这个抽取出来的内部类MyIterator，它是不加static的
         *
         * 当内部类用到了外部类的成员变量时候，就不能加static
         * 因为static的意思是不依赖外部类实例的存在，而成员变量是依赖外部类的对象的
         *
         * 而Node节点类是可以加static的，因为它不依赖外部类的对象的
         *
         * 内部类能加就加，不能加就不加，建议加static
         */
        return new MyIterator();
    }

    private class MyIterator implements Iterator {
        Node pointer = head;//初始值指向头节点

        @Override
        public boolean hasNext() {//是否有下一个元素
            return pointer != null;
        }

        @Override
        public Object next() {//返回当前值，并指向下一个元素
            int v = pointer.value;
            pointer = pointer.next;
            return v;
        }
    }


    /**
     * 经过loop3()和loop4()分别单元测试，发现loop3()和loop4()的结果是不一样的
     * 这是递归的两种不同的思路
     * loop3()是先打印，再递归
     * loop4()是先递归，再打印
     */

    /**
     * 递归遍历打印
     */
    public void loop3() {
        recursion(head);
    }

    public void loop4() {
        recursion1(head);
    }

    public void loop5(Consumer<Integer> before, Consumer<Integer> after) {
        recursion3(head, before, after);
    }

    /**
     * 递归遍历
     * 递归遍历的核心思想是：把一个大的问题，转化为一个小的问题
     * <p>
     * 想象成针对某个节点要进行的操作，就是一个小问题
     * <p>
     * AOP的前置通知、后置通知
     */
    private void recursion(Node curr) {
        if (curr == null) {//递归需要一个终止条件
            return;
        }
        //打印在前
        System.out.println("before: " + curr.value);
        //递归在后
        recursion(curr.next);//这样自己调用自己称为递归
        System.out.println("after: " + curr.value);
    }

    private void recursion1(Node curr) {
        if (curr == null) {//递归需要一个终止条件
            return;
        }
        //递归在前
        recursion1(curr.next);//这样自己调用自己称为递归
        //打印在后
        System.out.println(curr.value);
    }

    private void recursion3(Node curr, Consumer<Integer> before, Consumer<Integer> after) {
        if (curr == null) {//递归需要一个终止条件
            return;
        }
//        System.out.println("before: " + curr.value);
        before.accept(curr.value);
        recursion(curr.next);//这样自己调用自己称为递归
//        System.out.println("after: " + curr.value);
        after.accept(curr.value);
    }
}



