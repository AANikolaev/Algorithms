package data_structures.stack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StackTest {

    private List<Stack<Integer>> stacks = new ArrayList<>();

    @Before
    public void setup() {
        stacks.add(new ListStack<Integer>());
        stacks.add(new ArrayStack<Integer>());
        stacks.add(new IntStack(2));
    }


    @Test
    public void testPush() {
        for (Stack<Integer> stack : stacks) {
            stack.push(2);
            assertEquals(stack.size(), 1);
        }
    }

    @Test
    public void testPeek() {
        for (Stack<Integer> stack : stacks) {
            stack.push(2);
            assertEquals(2, (int) (Integer) stack.peek());
            assertEquals(stack.size(), 1);
        }
    }

    @Test
    public void testPop() {
        for (Stack<Integer> stack : stacks) {
            stack.push(2);
            assertEquals(2, (int) stack.pop());
            assertEquals(stack.size(), 0);
        }
    }

    @Test
    public void testExhaustively() {
        for (Stack<Integer> stack : stacks) {
            assertTrue(stack.isEmpty());
            stack.push(1);
            assertEquals(false, stack.isEmpty());
            stack.push(2);
            assertEquals(stack.size(), 2);
            assertEquals(2, (int) stack.peek());
            assertEquals(stack.size(), 2);
            assertEquals(2, (int) stack.pop());
            assertEquals(stack.size(), 1);
            assertEquals(1, (int) stack.peek());
            assertEquals(stack.size(), 1);
            assertEquals(1, (int) stack.pop());
            assertEquals(stack.size(), 0);
            assertEquals(true, stack.isEmpty());
        }
    }

    // BenchMark IntStack vs ArrayDeque.
    @Test
    public void benchMarkTest() {

        int n = 10000000;
        IntStack intStack = new IntStack(n);

        // IntStack times at around 0.0324 seconds
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) intStack.push(i);
        for (int i = 0; i < n; i++) intStack.pop();
        long end = System.nanoTime();
        System.out.println("IntStack Time: " + (end - start) / 1e9);

        // ArrayDeque times at around 1.438 seconds
        //    java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>();
        //    java.util.Stack<Integer> arrayDeque = new java.util.Stack<>();
        java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>(n); // strangely the
        // ArrayQueue is slower when you give it an initial capacity.
        start = System.nanoTime();
        for (int i = 0; i < n; i++) arrayDeque.push(i);
        for (int i = 0; i < n; i++) arrayDeque.pop();
        end = System.nanoTime();
        System.out.println("ArrayDeque Time: " + (end - start) / 1e9);

        Stack<Integer> listStack = new ListStack<>();

        start = System.nanoTime();
        for (int i = 0; i < n; i++) listStack.push(i);
        for (int i = 0; i < n; i++) listStack.pop();
        end = System.nanoTime();
        System.out.println("ListStack Time: " + (end - start) / 1e9);

        Stack<Integer> arrayStack = new ArrayStack<>();

        start = System.nanoTime();
        for (int i = 0; i < n; i++) arrayStack.push(i);
        for (int i = 0; i < n; i++) arrayStack.pop();
        end = System.nanoTime();
        System.out.println("ArrayStack Time: " + (end - start) / 1e9);
    }
}