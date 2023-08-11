package org.example.datastructure;

public interface Stack<E> {

    /**
     * 向栈顶压入元素
     * @param value 待压入元素
     * @return 压入成功返回true，否则返回false
     */
    boolean push(E value);

    /**
     * 从栈顶弹出元素
     * @return 栈非空返回栈顶元素，否则返回null
     */
    E pop();


    /**
     * 返回栈顶元素，但不弹出
     * @return 栈非空返回栈顶元素，否则返回null
     */
    E peek();

    /**
     * 判断栈是否为空
     * @return 空返回true，否则返回false
     */
    boolean isEmpty();

    /**
     * 判断栈是否已满
     * @return 已满返回true，否则返回false
     */
    boolean isFull();

}
