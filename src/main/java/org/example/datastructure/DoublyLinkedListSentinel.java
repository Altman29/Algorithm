package org.example.datastructure;

import java.util.Iterator;

/**
 * 双向链表 带哨兵节点
 * 俩个哨兵节点，一个头哨兵，一个尾哨兵
 * 也就是说，链表中至少有俩个节点
 * <p>
 * 双向链表的优点：从尾部直接能获取最后一个节点
 */
public class DoublyLinkedListSentinel implements Iterable<Integer> {

    static class Node {
        Node prev;//上一个节点
        int value;//值
        Node next;//下一个节点

        //构造方法 方便初始化
        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;//头哨兵
    private Node tail;//尾哨兵

    public DoublyLinkedListSentinel() {
        head = new Node(null, 666, null);
        tail = new Node(null, 888, null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 根据索引查找节点
     */
    private Node findNode(int index) {
        int i = -1;//头哨兵也要参与遍历所以从-1开始
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }


    public void addFirst(int value) {
        insert(0, value);
    }

    public void removeFirst() {
        remove(0);
    }

    /**
     * 向列表尾添加元素
     */
    public void addLast(int value) {
        Node last = tail.prev;
        Node added = new Node(last, value, tail);
        last.next = added;
        tail.prev = added;
    }

    /**
     * 删除列表尾元素
     */
    public void removeLast() {
        Node removed = tail.prev;
        if (removed == head) {
            throw illegalIndex();
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    /**
     * 向索引位置插入节点
     */
    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex();
        }
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);//新节点的上一个节点是prev，下一个节点是next
        prev.next = inserted;//prev的下一个节点是inserted
        next.prev = inserted;//next的上一个节点是inserted
    }

    /**
     * 删除索引位置的节点
     */
    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex();
        }
        Node removed = prev.next;
        if (removed == tail) {
            throw illegalIndex();
        }
        Node next = removed.next;

        prev.next = next;
        next.prev = prev;
    }

    private static IllegalArgumentException illegalIndex() {
        return new IllegalArgumentException("index illegal");
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }
}
