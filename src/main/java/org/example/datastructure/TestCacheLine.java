package org.example.datastructure;

import org.springframework.util.StopWatch;

/**
 * 二维数组
 * 缓存和局部性原理
 */
public class TestCacheLine {

    // 二维数组遍历，先行后列
    public static void ij(int[][] a, int rows, int columns) {
        long sum = 0L;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }

    // 二维数组遍历，先列后行
    public static void ji(int[][] a, int rows, int columns) {
        long sum = 0L;
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int rows = 1_000_000;
        int columns = 14;
        int a[][] = new int[rows][columns];//初始都是0，没有给元素赋值

        StopWatch stopWatch = new StopWatch();

        stopWatch.start("ij");
        ij(a, rows, columns);
        stopWatch.stop();

        stopWatch.start("ji");
        ji(a, rows, columns);
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }
}
