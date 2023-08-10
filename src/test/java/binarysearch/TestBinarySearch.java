package binarysearch;


import org.example.binarysearch.BinarySearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinarySearch {

    @Test
    @DisplayName("binarySearchBasic 找到")
    public void test1() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, BinarySearch.binarySearchBasic(a, 7));
        assertEquals(1, BinarySearch.binarySearchBasic(a, 13));
        assertEquals(2, BinarySearch.binarySearchBasic(a, 21));
        assertEquals(3, BinarySearch.binarySearchBasic(a, 30));
        assertEquals(4, BinarySearch.binarySearchBasic(a, 38));
        assertEquals(5, BinarySearch.binarySearchBasic(a, 44));
        assertEquals(6, BinarySearch.binarySearchBasic(a, 52));
        assertEquals(7, BinarySearch.binarySearchBasic(a, 53));
    }

    @Test
    @DisplayName("binarySearchBasic 没找到")
    public void test2() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(-1, BinarySearch.binarySearchBasic(a, 0));
        assertEquals(-1, BinarySearch.binarySearchBasic(a, 15));
        assertEquals(-1, BinarySearch.binarySearchBasic(a, 62));
    }


    @Test
    @DisplayName("binarySearchLeftMost")
    public void test3() {
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        assertEquals(0, BinarySearch.binarySearchLeftMost(a, 1));
        assertEquals(1, BinarySearch.binarySearchLeftMost(a, 2));
        assertEquals(2, BinarySearch.binarySearchLeftMost(a, 4));
        assertEquals(5, BinarySearch.binarySearchLeftMost(a, 5));
        assertEquals(6, BinarySearch.binarySearchLeftMost(a, 6));
        assertEquals(7, BinarySearch.binarySearchLeftMost(a, 7));

        assertEquals(-1, BinarySearch.binarySearchLeftMost(a, 0));
        assertEquals(-1, BinarySearch.binarySearchLeftMost(a, 3));
        assertEquals(-1, BinarySearch.binarySearchLeftMost(a, 8));
    }
}
