package org.example.datastructure;

import java.util.Iterator;

/**
 * 基于单向环形链表实现的队列
 * <p>
 * 队列只需要操作头，尾部不需要操作，所以只需要一个指针即可
 *
 * @param <E>
 */

public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

    /**
     * 节点类
     */
    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    Node<E> head = new Node<>(null, null);
    Node<E> tail = head;
    private int size;// 节点数
    private int capacity = Integer.MAX_VALUE;// 队列容量

    {
        tail.next = head;
    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    public LinkedListQueue() {
    }

    @Override
    public boolean offer(E val) {
        if (isFull()) return false;
        Node<E> added = new Node<>(val, head);
        tail.next = added;
        tail = added;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        Node<E> first = head.next;
        head.next = first.next;
        if (first == tail) tail = head;
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
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
                return p != head;
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
