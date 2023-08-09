package org.example.binarysearch;

import java.util.Arrays;

public class BinarySearch {
    /**
     * 二分查找基础班
     * a: 待查找的升序数组
     * target: 待查找的目标
     * <p>
     * 找到则返回索引
     * 找不到返回-1
     */
    public static int binarySearchBasic(int[] a, int target) {
        Arrays.toString(a);
        int i = 0, j = a.length - 1;//设置指针和初值
        while (i <= j) {//范围内有东西
//            int m = (i + j) / 2;//java除法会自动取整(向下取整，找到中间索引)
            int m = (i + j) >>> 1;//右移相当于除以2
            if (target < a[m]) {
                //如果目标在中间值的左边，设置右侧指针移至中间索引-1
                j = m - 1;
            } else if (a[m] < target) {
                //如果目标在中间值的右边，设置左侧指针移至中间索引+1
                i = m + 1;
            } else {
                //找到了
                return m;
            }
        }
        return -1;
    }

    /**
     * TestBinarySearch俩个测试用例都测试通过了。下面分析一下。
     *
     * Q：为什么是i<=j 意味着区间内有未比较得元素，而不是i<j ？
     * A：因为i=j 指向的元素也有可能是要查找的目标，如果没有等号，就会漏掉一次比较；
     *
     * Q：(i+j)/2 有没有问题？为什么使用右移代替？
     * A：因为如果数组无线大，j初始是Integer.MAX_VALUE-1。第一次(i+j)/2没问题，
     * 但是如果此时，目标值比中间值大，需要把左侧i边界设置为m+1，
     * 那么此时，再进行取中间索引时候，(i+j)/2. 一个是Integer.MAX_VALUE的一半加一，一个是MAX_VALUE
     * 就会超过正整数能表达的范围，就会得到一个负数。
     * ！负数是补码的形式，符号位不变，数值为取反。！所以会得到一个负数；
     * java里面二进制数都是有符号的，最高位是符号位。
     *
     * Q：如何解决上面的问题呢？
     * A：使用 无符号右移 >>> 。最高位会用0补齐。 而除以2的运算不会动最高符号位！
     *
     * Q：如果负数呢？
     * A：先求补码，再右移，高位补1，再对剩余位取反；
     *
     * Q：为什么判断条件都写小于符号？
     * A：因为这里数组a是升序排列的，写成小于符号，相当于与数组排列的顺序是一致的。
     */


    /**
     * 二分查找改动版
     */
    public static int binarySearchFix(int[] a, int target) {
        int i = 0, j = a.length;                //fix 1
        while (i < j) {                         //fix 2
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;                          //fix 3
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }


}
