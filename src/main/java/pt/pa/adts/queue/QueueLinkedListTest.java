package pt.pa.adts.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the QueueLinkedList class.
 */
public class QueueLinkedListTest {

    private QueueLinkedList<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new QueueLinkedList<>();
    }

    @Test
    public void testEnqueueDequeueFront_FIFO() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.front());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.front());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.front());
        assertEquals(3, queue.dequeue());
    }

    @Test
    public void testDequeueOnEmptyQueue_ThrowsException() {
        assertThrows(QueueEmptyException.class, () -> {
            queue.dequeue();
        });
    }

    @Test
    public void testFrontOnEmptyQueue_ThrowsException() {
        assertThrows(QueueEmptyException.class, () -> {
            queue.front();
        });
    }

    @Test
    public void testSize_AfterEnqueueAndDequeue() {
        assertEquals(0, queue.size());

        queue.enqueue(10);
        assertEquals(1, queue.size());

        queue.enqueue(20);
        assertEquals(2, queue.size());

        queue.dequeue();
        assertEquals(1, queue.size());

        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void testSize_AfterClear() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.clear();
        assertEquals(0, queue.size());
    }

    @Test
    public void testIsEmpty_AfterEnqueueAndDequeue() {
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmpty_AfterClear() {
        queue.enqueue(1);
        queue.enqueue(2);

        queue.clear();
        assertTrue(queue.isEmpty());
    }
}
