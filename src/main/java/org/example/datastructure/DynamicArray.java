package org.example.datastructure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组
 */
public class DynamicArray implements Iterable<Integer> {

    private int size = 0;//逻辑大小
    private int capacity = 8;//容量 ,java中arraylist默认是10

    //    private int[] array = new int[capacity];//延迟加载
    private int[] array = {};

    /**
     * 添加元素到数组末尾
     *
     * @param element 待添加的元素
     */
    public void addLast(int element) {
        //array[size] = element;
        //size++;
        add(size, element);
    }

    /**
     * 添加元素到指定位置
     *
     * @param index   索引位置
     * @param element 待添加的元素
     * 时间复杂度
     *    头部插入：O(n)
     *    中间插入：O(n)
     *    尾部插入：O(1)
     */
    public void add(int index, int element) {
        //扩容检查
        checkAndGrow();
        //检查index是否合法
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index:" + index + ",size:" + size);
        }
        //拷贝，把目标index后的元素都往后移动一位
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    /**
     * 扩容检查
     */
    private void checkAndGrow() {
        if (size == 0) {
            array = new int[capacity];
        } else if (size == capacity) {
            //扩容，1.5倍、1.618倍、2倍：建议这些
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            //拷贝
            System.arraycopy(array, 0, newArray, 0, size);
            //替换
            array = newArray;
        }
    }

    /**
     * 删除指定位置的元素
     *
     * @param index
     * @return
     */
    public int remove(int index) {//[0..size)
        int removed = array[index];
        if (index < size - 1) {
            //拷贝，把目标index后的元素都往前移动一位
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            size--;
        }
        return removed;
    }

    /**
     * 查询指定位置的元素
     *
     * @param index 索引
     *
     * 时间复杂度：O(1)
     */
    public int get(int index) {// [0..size)
        return array[index];
    }

    /**
     * 使用函数式接口Consumer,遍历数组，
     * 对每个元素执行consumer.accept(array[i])，令调用方执行自定义的操作
     *
     * @param consumer
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            // 提供array[i]
            // 返回void
            consumer.accept(array[i]);
        }
    }

    /**
     * 迭代器遍历
     * 实现Iterable接口，使得DynamicArray可以使用foreach语法
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;//index < size表示还有元素
            }

            @Override
            public Integer next() {
                return array[index++];
            }
        };
    }

    /**
     * 获取流对象
     */
    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }
}
