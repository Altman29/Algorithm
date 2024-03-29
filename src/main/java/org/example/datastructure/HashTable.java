package org.example.datastructure;

/**
 * 哈希表
 * <p>
 * 给每份数据分配一个编号，放入数组、
 * 建立编号与数组索引的关系，将来可以通过编号快速查找到数据。
 * 存在问题：
 * 1.理想情况下，数组容纳所有数据，但是不现实，因为数组需要连续内存存储的；
 * 2.现实是不能说为了容纳所有数据造一个超大数组，编号也有可能重复的；
 * 解决：
 * 1.有限长度的数组，以【拉链】方式存储数据；
 * 2.允许编号适当重复，通过数据自身进行区分；
 */
public class HashTable {

    //节点类
    public static class Entry {
        int hash;//哈希码
        Object key;//键
        public Object value;//值
        public Entry next;//下一个节点

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    public Entry[] table = new Entry[16];//哈希表，数组，每个元素是一个链表的头节点
    public int size = 0;//元素个数
    float loadFactor = 0.75f;//负载因子 16*0.75=12  也叫阈值
    int threshold = (int) (table.length * loadFactor);//阈值 用变量记录，后面可以复用

    /**
     * ！！！
     * 求模运算替换为位运算
     *  -前提：数组长度必须是2的n次方
     *  -hash % 数组长度 等价与 hash & (数组长度-1)
     */

    /**
     * 查询
     * 根据hash码获取Value
     */
    public Object get(int hash, Object key) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) return null;
        Entry p = table[idx];//头节点
        while (p != null) {
            if (p.key == key) return p.value;
            p = p.next;
        }
        return null;
    }

    /**
     * 向hash表存入新key value，
     * 分三种情况：
     * 找到空位，直接插入
     * 找链表，如果key已存在，替换value
     * 找链表，如果key不存在，插入链表尾部
     */
    public void put(int hash, Object key, Object value) {
        int idx = hash & (table.length - 1);//hash & (数组长度-1)
        if (table[idx] == null) {//1.找到空位 直接插入
            table[idx] = new Entry(hash, key, value);
        } else {
            //2.无空位，找链表。如果key已存在，替换value
            Entry p = table[idx];
            while (p != null) {
                if (p.key.equals(key)) {
                    p.value = value;//更新
                    return;
                }
                if (p.next == null) break;
                p = p.next;
            }
            //3.找链表，如果key不存在，插入链表尾部
            p.next = new Entry(hash, key, value);
        }
        size++;
        if (size > threshold) {
            resize();
        }
    }

    /**
     * 根据hash 删除，返回删除的value
     */
    Object remove(int hash, Object key) {
        int idx = hash & (table.length - 1);//hash & (数组长度-1)
        if (table[idx] == null) return null;
        Entry p = table[idx];//头节点
        Entry prev = null;//前一个节点
        while (p != null) {
            if (p.key.equals(key)) {//找到了 删除
                Object value = p.value;
                if (prev == null) {//删除的是头节点
                    table[idx] = p.next;
                } else {//删除的是中间节点
                    prev.next = p.next;
                }
                size--;
                return value;
            }
            prev = p;//记录前一个节点
            p = p.next;
        }
        return null;
    }

    /**
     * 扩容
     * <p>
     * 负载因子 = size / table.length
     * 不易过小也不易过大，
     * 过小，浪费，空间利用率低
     * 过大，快满了，效率低
     * <p>
     * 3/4 也是 0.75是经验值 比较合适
     * 扩容之后，会重新计算每个元素的位置
     */
    void resize() {
        Entry[] newTable = new Entry[table.length << 2];//新数组 容量是原来的2倍
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i];//头节点
            if (p != null) {
                Entry a = null;
                Entry b = null;
                Entry aHead = null;
                Entry bHead = null;
                while (p != null) {
                    //拆分链表 移动到新数组
                /*
                拆分规律：
                    一个链表最多拆分成两个链表
                    hash&table.length 为0的一组
                    hash&table.length 为1的一组
                 */
                    if ((p.hash & table.length) == 0) {
                        //a组
                        if (a != null) {
                            a.next = p;
                        } else {
                            aHead = p;//记录头节点
                        }
                        a = p;
                    } else {
                        //b组
                        if (b != null) {
                            b.next = p;
                        } else {
                            bHead = p;//记录头节点
                        }
                        b = p;
                    }
                    p = p.next;
                }
                //a、b组，各自的头节点重置规律
                //a:保持索引位置不变
                //b:索引位置=原索引位置+原数组长度
                if (a != null) {
                    a.next = null;
                    newTable[i] = aHead;
                }
                if (b != null) {
                    b.next = null;
                    newTable[i + table.length] = bHead;
                }
            }
        }
        table = newTable;
        threshold = (int) (table.length * loadFactor);//更新阈值size
    }


    /**
     * hash 改造
     * <p>
     * hash码，一种简单的方式，可以直接使用jdk的 object.hashCode()
     * 所以上述 get、put、remove方法都可以加一个重载，去掉hash参数
     */

    private static int hash(Object key) {
        return key.hashCode();
    }

    public Object get(Object key) {
        int hash = hash(key);
        return get(hash, key);
    }

    public void put(Object key, Object value) {
        int hash = hash(key);
        put(hash, key, value);
    }

    Object remove(Object key) {
        int hash = hash(key);
        return remove(hash, key);
    }


}
