package org.example.datastructure;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>, Iterable<E> {

    private final E[] array;
    private int top;//栈顶指针

    /**
     * 底            顶
     * 0  1  2  3  4
     * 因为右边数组更好操作，与链表是反方向的
     */

    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if (isFull()) return false;
        array[top++] = value;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        return array[--top];
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = top;//指向栈顶，从右往左遍历

            @Override
            public boolean hasNext() {
                return p > 0;
            }

            @Override
            public E next() {
                return array[--p];
            }
        };
    }
}
