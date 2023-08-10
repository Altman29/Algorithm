package binarysearch;

import org.example.datastructure.BasicSingleLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestSingleLinkedList {

    @Test
    @DisplayName("单向链表 添加和循环")
    public void test1() {
        BasicSingleLinkedList list = new BasicSingleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

//        list.loop1(System.out::println);
        list.loop2(System.out::println);
    }

    @Test
    @DisplayName("单向链表 iterable循环")
    public void test2() {
        BasicSingleLinkedList list = new BasicSingleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    @DisplayName("单向链表 addLast")
    public void test3() {
        BasicSingleLinkedList list = new BasicSingleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        Assertions
                .assertIterableEquals(Arrays.asList(1, 2, 3, 4), list);

        list.loop1(System.out::println);
    }

    @Test
    @DisplayName("单向链表 索引")
    public void test4() {
        BasicSingleLinkedList list = new BasicSingleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(2, list.get(1));
        Assertions.assertEquals(3, list.get(2));
        Assertions.assertEquals(4, list.get(3));
        Assertions.assertEquals(4, list.get(4));
    }


    @Test
    @DisplayName("单向链表 插入")
    public void test5() {
        BasicSingleLinkedList list = new BasicSingleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.insert(2, 5);
        list.loop1(System.out::println);
    }


    @Test
    @DisplayName("单向链表 removeFirst")
    public void test6() {
        BasicSingleLinkedList list = new BasicSingleLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.removeFirst();
//        list.loop1(System.out::println);
//        System.out.println("==========");
        list.removeFirst();
//        list.loop1(System.out::println);
//        System.out.println("==========");
        list.removeFirst();
//        list.loop1(System.out::println);
//        System.out.println("==========");
        list.removeFirst();
        list.loop1(System.out::println);
    }
}
