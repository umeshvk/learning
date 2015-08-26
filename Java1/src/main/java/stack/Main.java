package stack;

import java.util.Stack;

/**
 * Created by umesh on 8/25/15.
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean empty = stack.empty();
        stack.push(100);
        empty = stack.empty();
        stack.push(200);
        stack.peek();
        Integer val = stack.pop();
        val = stack.pop();
        //val = stack.peek();
        val = 2000;

    }
}
