package binarysearch;

import org.example.datastructure.HashTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestHash {

    @Test
    public void put() {
        HashTable hashTable = new HashTable();//默认容量16
        //1 % 16 = 1
        hashTable.put(1, "zhang", "张三");
        //17 % 16 = 1 与上面的key冲突，会放到链表中
        hashTable.put(17, "li", "李四");
        hashTable.put(2, "wang", "王五");
        Assertions.assertEquals(3, hashTable.size);
        Assertions.assertEquals("张三", hashTable.table[1].value);
        Assertions.assertEquals("李四", hashTable.table[1].next.value);
        Assertions.assertEquals("王五", hashTable.table[2].value);

        hashTable.put(1, "zhang", "张四");
        hashTable.put(17, "li", "李五");
        Assertions.assertEquals("张四", hashTable.table[1].value);
        Assertions.assertEquals("李五", hashTable.table[1].next.value);

    }
}
