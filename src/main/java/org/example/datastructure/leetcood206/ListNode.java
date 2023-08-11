package org.example.datastructure.leetcood206;

/**
 * 节点类
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("[");
        ListNode cur = this;
        while (cur != null) {
            stringBuilder.append(cur.val);
            if (cur.next != null) {
                stringBuilder.append(",");
            }
            cur = cur.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
