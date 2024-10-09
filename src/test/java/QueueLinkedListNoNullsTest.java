import org.junit.jupiter.api.Test;
import pt.pa.adts.queue.NullNotAllowedException;
import pt.pa.adts.queue.QueueEmptyException;
import pt.pa.adts.queue.QueueLinkedListNoNulls;

import static org.junit.jupiter.api.Assertions.*;

public class QueueLinkedListNoNullsTest {

    @Test
    public void testEnqueueNull_ThrowsException() {
        QueueLinkedListNoNulls<String> queue = new QueueLinkedListNoNulls<>();
        assertThrows(NullNotAllowedException.class, () -> queue.enqueue(null));
    }

    @Test
    public void testEnqueueDequeue() throws QueueEmptyException {
        QueueLinkedListNoNulls<String> queue = new QueueLinkedListNoNulls<>();
        queue.enqueue("A");
        queue.enqueue("B");

        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
    }

    @Test
    public void testSizeAfterClear() {
        QueueLinkedListNoNulls<String> queue = new QueueLinkedListNoNulls<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.clear();
        assertEquals(0, queue.size());
    }

    @Test
    public void testIsEmpty() {
        QueueLinkedListNoNulls<String> queue = new QueueLinkedListNoNulls<>();
        assertTrue(queue.isEmpty());
        queue.enqueue("A");
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }
}
