package data_structures.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;

import static org.junit.Assert.*;

public class IntQueueTest {

    @Before
    public void setup() {
    }

    @Test
    public void testEmptyQueue() {
        IntQueue queue = new IntQueue(0);
        assertTrue(queue.isEmpty());
        assertEquals(queue.size(), 0);
    }

    @Test
    public void testOfferOneElement() {
        IntQueue queue = new IntQueue(1);
        queue.offer(77);
        assertEquals(queue.size(), 1);
    }

    @Test
    public void testAll() {
        int n = 5;
        IntQueue queue = new IntQueue(10);
        assertTrue(queue.isEmpty());
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
            assertFalse(queue.isEmpty());
        }
        for (int i = 1; i <= n; i++) {
            assertEquals(i, (int) queue.peek());
            assertEquals(i, (int) queue.poll());
            assertEquals(queue.size(), n - i);
        }
        assertTrue(queue.isEmpty());
        n = 8;
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
            assertFalse(queue.isEmpty());
        }
        for (int i = 1; i <= n; i++) {
            assertEquals(i, (int) queue.peek());
            assertEquals(i, (int) queue.poll());
            assertEquals(queue.size(), n - i);
        }
        assertTrue(queue.isEmpty());
        n = 9;
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
            assertFalse(queue.isEmpty());
        }
        for (int i = 1; i <= n; i++) {
            assertEquals(i, (int) queue.peek());
            assertEquals(i, (int) queue.poll());
            assertEquals(queue.size(), n - i);
        }
        assertTrue(queue.isEmpty());
        n = 10;
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
            assertFalse(queue.isEmpty());
        }
        for (int i = 1; i <= n; i++) {
            assertEquals(i, (int) queue.peek());
            assertEquals(i, (int) queue.poll());
            assertEquals(queue.size(), n - i);
        }
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testPeekOneElement() {
        IntQueue queue = new IntQueue(1);
        queue.offer(77);
        assertEquals(77, (int) queue.peek());
        assertEquals(queue.size(), 1);
    }

    @Test
    public void testpollOneElement() {
        IntQueue queue = new IntQueue(1);
        queue.offer(77);
        assertEquals(77, (int) queue.poll());
        assertEquals(queue.size(), 0);
    }

    @Test
    public void testRandom() {

        for (int qSize = 1; qSize <= 50; qSize++) {

            IntQueue intQ = new IntQueue(qSize);
            ArrayDeque<Integer> javaQ = new ArrayDeque<>(qSize);

            assertEquals(javaQ.isEmpty(), intQ.isEmpty());
            assertEquals(javaQ.size(), intQ.size());

            for (int operations = 0; operations < 5000; operations++) {

                double r = Math.random();

                if (r < 0.60) {
                    int elem = (int) (1000 * Math.random());
                    if (javaQ.size() < qSize) {
                        javaQ.offer(elem);
                        intQ.offer(elem);
                    }
                } else {
                    if (!javaQ.isEmpty()) {
                        assertEquals((int) javaQ.poll(), (int) intQ.poll());
                    }
                }

                assertEquals(javaQ.isEmpty(), intQ.isEmpty());
                assertEquals(javaQ.size(), intQ.size());
            }
        }
    }

    // BenchMark IntQueue vs ArrayDeque.
    @Test
    public void benchMarkTest() {

        int n = 10000000;
        IntQueue intQ = new IntQueue(n);

        // IntQueue times at around 0.0324 seconds
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) intQ.offer(i);
        for (int i = 0; i < n; i++) intQ.poll();
        long end = System.nanoTime();
        System.out.println("==>> IntQueue Time: " + (end - start) / 1e9);

        // ArrayDeque times at around 1.438 seconds
        java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>();
//         java.util.ArrayDeque <Integer> arrayDeque = new java.util.ArrayDeque<>(n); // strangely the
        // ArrayQueue is slower when you give it an initial capacity.
        start = System.nanoTime();
        for (int i = 0; i < n; i++) arrayDeque.offer(i);
        for (int i = 0; i < n; i++) arrayDeque.poll();
        end = System.nanoTime();
        System.out.println("==>> ArrayDeque Time: " + (end - start) / 1e9);
    }
}