package binarysearch;

import org.example.datastructure.RecursionLinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestRecursion {

    @Test
    public RecursionLinkedList getLinkedList() {
        RecursionLinkedList list = new RecursionLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        return list;
    }

    @Test
    public void test() {
        RecursionLinkedList list = getLinkedList();
        list.loop3();
        /**
         * 打印结果：
         * 1
         * 2
         * 3
         * 4
         */
    }

    @Test
    public void test1() {
        RecursionLinkedList list = getLinkedList();
        list.loop4();
        /**
         * 打印结果：
         * 4
         * 3
         * 2
         * 1
         */
    }

    @Test
    @DisplayName("测试递归遍历")
    public void test2() {
        RecursionLinkedList list = getLinkedList();
        list.loop5(
                value -> System.out.println("before: " + value),
                value -> System.out.println("after: " + value));
    }
}
