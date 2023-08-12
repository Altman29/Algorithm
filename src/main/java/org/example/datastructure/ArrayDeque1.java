package org.example.datastructure;

import java.util.Iterator;

/**
 * 基于循环数组实现的双端队列
 * 循环数组动的是头尾指针，不动的是数组元素
 * <p>
 * tail 停下来的位置不存储，会浪费一个位置
 * <p>
 * <p>
 * h - head
 * tail - tail
 * <p>
 * h
 * t
 * 0  1  2  3
 * a  b     c
 * offerLast(a)     先添加元素 tail++
 * offerLast(b)
 * offerFirst(c)    先head-- 再添加元素
 * <p>
 * pollFirst()      先取元素 head++
 * pollLast()       先tail-- 再取元素
 * <p>
 * head==tail 空
 * head~tail == 数组长度-1 满
 */
public class ArrayDeque1<E> implements Deque<E>, Iterable<E> {

    E[] array;
    int head;
    int tail;

    @SuppressWarnings("all")
    public ArrayDeque1(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    static int inc(int i, int length) {
        if (i + 1 >= length)
            return 0;
        return i + 1;
    }

    static int dec(int i, int length) {
        if (i - 1 < 0)
            return length - 1;
        return i - 1;
    }

    @Override
    public boolean offerFirst(E e) {
        if (isFull()) return false;
        head = dec(head, array.length);
        array[head] = e;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) return false;
        array[tail] = e;
        tail = inc(tail, array.length);
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) return null;
        E e = array[head];
        array[head] = null;//help gc
        head = inc(head, array.length);
        return e;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) return null;
        tail = dec(tail, array.length);
        E e = array[tail];
        array[tail] = null;//help gc
        return e;
    }

    @Override
    public E peekFirst() {
        if (isEmpty())
            return null;
        return array[head];
    }

    @Override
    public E peekLast() {
        if (isEmpty())
            return null;
        return array[dec(tail, array.length)];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        if (tail > head) {
            return tail - head == array.length - 1;
        } else if (tail < head) {
            return head - tail == 1;
        } else {
            return false;
        }
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
                E e = array[p];
                p = inc(p, array.length);
                return e;
            }
        };
    }
}
