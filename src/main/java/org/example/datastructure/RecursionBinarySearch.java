package org.example.datastructure;

/**
 * 递归二分查找
 */
public class RecursionBinarySearch {

    public static void main(String[] args) {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        System.out.println(search(a, 7)); // 0
        System.out.println(search(a, 13));// 1
        System.out.println(search(a, 21));// 2
        System.out.println(search(a, 53));// 7
    }

    public static int search(int[] a, int target) {
        return f(a,target, 0, a.length - 1);
    }

    /**
     * left和right不对外暴露，让调用者更加简单
     * @param a 数组
     * @param target 目标
     * @param left 左侧指针
     * @param right 右侧指针
     * @return 目标索引<br>
     * 找不到返回-1
     *
     */
    private static int f(int[] a, int target, int left, int right) {
        if (left > right) return -1;//递归终止条件
        int m = (left + right) >>> 1;
        if (target < a[m]) {    // target在左边
            return f(a, target, left, m - 1);
        } else if (a[m] < target) {     // target在右边
            return f(a, target, m + 1, right);
        } else {
            return m;
        }
    }
}
