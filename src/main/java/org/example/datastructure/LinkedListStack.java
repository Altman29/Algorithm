package org.example.datastructure;

import java.util.Iterator;

/**
 * 链表实现栈
 * 含哨兵单向链表
 */
public class LinkedListStack<E> implements Stack<E>, Iterable<E> {

    static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int capacity;
    private int size;

    /**
     * 哨兵节点
     */
    private Node<E> head = new Node<>(null, null);

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    /**
     * head -> 1 -> null
     * head -> 2 -> 1 -> null
     */
    @Override
    public boolean push(E value) {
        if (isFull()) return false;
//        Node<E> added = new Node<>(value, head.next);
//        head.next = added;
        head.next = new Node<>(value, head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        Node<E> first = head.next;//找到第一个节点
        head.next = first.next;//跳过(删除)第一个节点
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        Node<E> first = head.next;//找到第一个节点
        return first.value;
    }

    @Override
    public boolean isEmpty() {
//        return head.next == null;
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
