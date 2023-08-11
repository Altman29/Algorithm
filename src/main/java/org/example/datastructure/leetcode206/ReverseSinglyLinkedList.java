package org.example.datastructure.leetcode206;


/**
 * 反转单链表 力扣206
 */
public class ReverseSinglyLinkedList {

    /**
     * 方法1：
     * 构造一个新链表，遍历原链表，每次都将遍历到的节点插入到新链表的头部
     *
     * @param o1 原链表head
     * @return 新链表head
     */
    public ListNode reverse1(ListNode o1) {
        ListNode node = null;
        ListNode p = o1;
        while (p != null) {
            node = new ListNode(p.val, node);
            p = p.next;
        }
        return node;
    }

    /**
     * 方法2：
     * 与方法1类似，构造一个新链表，从原链表头部移除节点，插入到新链表的头部
     * 完成后新链表就是倒序的，
     * 区别在于原题目未提供节点外层容器类，
     * 这里需要自己提供一个，另外一个区别是并不去构造新节点；
     */
    static class List {
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public ListNode removeFirst() {
            ListNode first = head;
            if (first != null) head = first.next;
            return first;
        }

        public void addFirst(ListNode first) {
            first.next = head;
            head = first;
        }
    }

    public ListNode reverse2(ListNode o1) {
        List list1 = new List(o1);
        List list2 = new List(null);
        while (list1.head != null) {
            list2.addFirst(list1.removeFirst());
        }
        return list2.head;
    }


    /**
     * 方法3：
     * 递归
     */
    public ListNode reverse3(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        ListNode last = reverse(p.next);
        p.next.next = p;
        p.next = null;
        return last;
    }

    /**
     * 方法4：
     * o1
     * n1
     * 1->2->3->4->5->null
     * <p>
     * n1 o1
     * 2->1->3->4->5->null
     * <p>
     * n1    o1
     * 3->2->1->4->5->null
     * <p>
     * 从链表每次拿到第二个节点，将其从链表断开，插入头部，直至为null
     */
    public ListNode reverse4(ListNode o1) {
        if (o1 == null || o1.next == null) return o1;
        ListNode o2 = o1.next;
        ListNode n1 = o1;
        while (o2 != null) {
            o1.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = o1.next;
        }
        return n1;
    }

    /**
     * 方法5：
     * 递归
     * 类似方法2，把旧链表头部搬到新链表中
     * 只不过方法2时面向对象的addFirst、removeFirst方法，
     * 这里是面向过程的实现方式；
     */
    public ListNode reverse(ListNode o1) {
        if (o1 == null || o1.next == null) return o1;
        ListNode n1 = null;
        while (o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }


    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode n = new ReverseSinglyLinkedList().reverse(o1);
        System.out.println(n);
    }
}
