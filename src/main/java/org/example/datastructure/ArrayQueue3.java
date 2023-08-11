package org.example.datastructure;

import java.util.Iterator;

/**
 * 不用head和tail
 */
public class ArrayQueue3<E> implements Queue<E>, Iterable<E> {

    private final E[] array;
    /**
     * 与前俩种实现主要区别就是，head和tail不存真实索引了，而是存相对索引
     * 用的时候模于数组长度即可
     */
    private int head = 0;
    private int tail = 0;
    private int capacity;

    @SuppressWarnings("all")
    public ArrayQueue3(int capacity) {
        array = (E[]) new Object[this.capacity];
    }

    @Override
    public boolean offer(E val) {
        if (isFull()) return false;
        array[tail % array.length] = val;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E val = array[head % array.length];
        head++;
        return val;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[head % array.length];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E e = array[p % array.length];
                p++;
                return e;
            }
        };
    }
}
