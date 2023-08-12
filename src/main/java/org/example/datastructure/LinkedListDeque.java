package org.example.datastructure;

import java.util.Iterator;

/**
 * 基于双向环形链表实现的双端队列
 * <p>
 * 注：双向和双端是两个概念，
 * 双向是指链表节点有两个指针，一个指向前一个节点，一个指向后一个节点；
 * 双端是指队列两端都可以操作添加和删除。
 * <p>
 * 为什么要用双向链表？
 * 因为双端队列需要操作尾端，所以需要尾指针，而单向链表只有头指针，所以需要双向链表。
 * <p>
 * 为什么要用环形链表？
 * 因为环形链表可以用一个哨兵，即充当头指针又充当尾指针，这样就可以省去一个指针。
 */
public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {

    static class Node<E> {
        Node<E> prev;
        E value;
        Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    int capacity = Integer.MAX_VALUE;
    int size;
    Node<E> sentinel = new Node<>(null, null, null);//哨兵

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        //初始化哨兵
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /**
     * a added b
     * 向头部添加
     * a就是哨兵，b就是哨兵的next
     */
    @Override
    public boolean offerFirst(E e) {
        if (isFull()) return false;
        Node<E> a = sentinel;
        Node<E> b = sentinel.next;
        Node<E> added = new Node<>(a, e, b);
        a.next = added;
        b.prev = added;
        size++;
        return true;
    }

    /**
     * a added b
     * 向尾部添加
     * b就是哨兵，a就是哨兵的prev
     */
    @Override
    public boolean offerLast(E e) {
        if (isFull()) return false;
        Node<E> a = sentinel.prev;
        Node<E> b = sentinel;
        Node<E> added = new Node<>(a, e, b);
        a.next = added;
        b.prev = added;
        size++;
        return true;
    }

    /**
     * a removed b
     * 移除头部
     * a就是哨兵，b就是哨兵的next
     */
    @Override
    public E pollFirst() {
        if (isEmpty()) return null;
        Node<E> a = sentinel;
        Node<E> removed = sentinel.next;
        Node<E> b = removed.next;
        a.next = b;
        b.prev = a;
        size--;
        return removed.value;
    }

    /**
     * a removed b
     * 移除尾部
     * b就是哨兵，a就是哨兵的prev
     */
    @Override
    public E pollLast() {
        if (isEmpty()) return null;
        Node<E> b = sentinel;
        Node<E> removed = sentinel.prev;
        Node<E> a = removed.prev;
        a.next = b;
        b.prev = a;
        size--;
        return removed.value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) return null;
        return sentinel.next.value;
    }

    @Override
    public E peekLast() {
        if (isEmpty()) return null;
        return sentinel.prev.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
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
