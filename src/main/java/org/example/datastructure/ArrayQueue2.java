package org.example.datastructure;

import java.util.Iterator;

/**
 * 用size判断空和满
 */
public class ArrayQueue2<E> implements Queue<E>, Iterable<E> {

    private E[] array;
    private int head;
    private int tail;
    private int size; // 队列元素个数
    private int capacity;

    @SuppressWarnings("all")
    public ArrayQueue2(int capacity) {
        array = (E[]) new Object[this.capacity];
    }

    @Override
    public boolean offer(E val) {
        if (isFull()) return false;
        array[tail] = val;
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E val = array[head];
        head = (head + 1) % array.length;
        size--;
        return val;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                E e = array[p];
                p = (p + 1) % array.length;
                count++;
                return e;
            }
        };
    }
}
