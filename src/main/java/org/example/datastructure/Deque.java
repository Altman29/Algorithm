package org.example.datastructure;

/**
 * 双端队列
 * 两端都可以操作添加和删除
 * queue 普通队列
 * deque 双端队列   double-ended queue
 */
public interface Deque<E> {


    /**
     * 向头部添加元素
     *
     * @param e 待添加元素
     * @return 添加成功返回true
     */
    boolean offerFirst(E e);

    /**
     * 向尾部添加元素
     *
     * @param e 待添加元素
     * @return 添加成功返回true
     */
    boolean offerLast(E e);

    /**
     * 从队列头部删除元素
     *
     * @return 头部元素
     */
    E pollFirst();


    /**
     * 从尾部获取元素并删除
     *
     * @return 尾部元素
     */
    E pollLast();


    /**
     * 从头部获取元素但不删除
     *
     * @return 头部元素
     */
    E peekFirst();


    /**
     * 从尾部获取元素但不删除
     *
     * @return 尾部元素
     */
    E peekLast();


    /**
     * 队列是否为空
     *
     * @return 空返回true, 否则返回false
     */
    boolean isEmpty();

    /**
     * 队列是否已满
     *
     * @return 满返回true, 否则返回false
     */
    boolean isFull();
}
