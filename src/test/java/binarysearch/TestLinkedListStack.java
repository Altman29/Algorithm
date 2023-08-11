package binarysearch;

import org.example.datastructure.LinkedListStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestLinkedListStack {
    @Test
    public void testPush() {
        LinkedListStack<Integer> stack = new LinkedListStack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertIterableEquals(stack, Arrays.asList(3, 2, 1));
    }
}
