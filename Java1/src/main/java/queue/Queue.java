package queue;

import java.util.ArrayDeque;

/**
 * Created by umesh on 8/25/15.
 */
public class Queue {
    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque();

        boolean empty = queue.isEmpty();
        queue.offer(100);
        empty = queue.isEmpty();
        queue.offer(200);
        queue.peek();
        Integer val = queue.poll();
        val = queue.poll();
        val = queue.peek();
        val = 2000;

    }
}
