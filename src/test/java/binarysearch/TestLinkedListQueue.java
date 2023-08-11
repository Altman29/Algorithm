package binarysearch;

import org.example.datastructure.LinkedListQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestLinkedListQueue {

    @Test
    public void offer() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue);
        Assertions.assertIterableEquals(queue, Arrays.asList(1, 2, 3, 4));
    }

    @Test
    public void peek() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        Assertions.assertEquals(1, queue.peek());
        queue.offer(2);
        Assertions.assertEquals(1, queue.peek());
    }

    @Test
    public void poll() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(4);

        Assertions.assertEquals(1,queue.poll());
        Assertions.assertEquals(2,queue.poll());
        Assertions.assertEquals(3,queue.poll());
        Assertions.assertEquals(4,queue.poll());
        Assertions.assertEquals(4,queue.poll());
        Assertions.assertNull(queue.poll());
    }
}
