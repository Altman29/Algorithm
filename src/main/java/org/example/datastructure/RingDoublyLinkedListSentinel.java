package org.example.datastructure;

import java.util.Iterator;

/**
 * 环形双向含哨兵链表
 */
public class RingDoublyLinkedListSentinel implements Iterable<Integer> {
    static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, 666, null);

    public RingDoublyLinkedListSentinel() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * 添加到链表头部
     */
    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * 添加到链表尾部
     */
    public void addLast(int value) {
        Node a = sentinel.prev;
        Node b = sentinel;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * 删除第一个
     */
    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IllegalArgumentException("Illegal argument");
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    /**
     * 删除最后一个
     */
    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IllegalArgumentException("Illegal argument");
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    /**
     * 根据值删除节点
     */
    public void removeByValue(int value) {
        Node removed = findByValue(value);
        if (removed == null) {
            throw new IllegalArgumentException("Illegal argument");
        }
        Node a = removed.prev;//前一个节点
        Node b = removed.next;//后一个节点
        a.next = b;//前一个节点的next指向后一个节点
        b.prev = a;//后一个节点的prev指向前一个节点
    }

    /**
     * 根据值找到节点
     */
    private Node findByValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node pointer = sentinel.next;

            @Override
            public boolean hasNext() {
                return pointer != sentinel;
            }

            @Override
            public Integer next() {
                int v = pointer.value;
                pointer = pointer.next;
                return v;
            }
        };
    }
}
