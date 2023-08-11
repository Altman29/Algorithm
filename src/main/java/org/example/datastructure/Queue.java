package org.example.datastructure;

/**
 * 队列
 */
public interface Queue<E> {

    /**
     * 向队列尾部添加一个元素
     * @param val 待插入值
     * @return 插入成功返回true，否则返回false
     */
    boolean offer(E val);

    /**
     * 从队列头部取出一个元素，并移除
     * @return 如果队列非空，返回队列头部元素，否则返回null
     */
    E poll();

    /**
     * 从队列头部取出一个元素，但不移除
     * @return 如果队列非空，返回队列头部元素，否则返回null
     */
    E peek();

    /**
     * 判断队列是否为空
     * @return 空返回true，否则返回false
     */
    boolean isEmpty();


    /**
     * 判断队列是否已满
     * @return 已满返回true，否则返回false
     */
    boolean isFull();

}
