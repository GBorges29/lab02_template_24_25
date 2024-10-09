package pt.pa.adts.queue;

/**
 * A queue implementation that does not allow null elements.
 *
 * @param <T> type of elements stored in the queue.
 */
public class QueueLinkedListNoNulls<T> extends QueueLinkedList<T> {

    @Override
    public void enqueue(T elem) throws NullNotAllowedException {
        if (elem == null) {
            throw new NullNotAllowedException("Null elements are not allowed in this queue.");
        }
        super.enqueue(elem);
    }
}
