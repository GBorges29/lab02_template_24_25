package pt.pa.adts.queue;

/**
 * This class must implement the Queue interface
 * @param <T>
 */
public class QueueLinkedList<T>  implements Queue<T> {

    private ListNode header, trailer;
    private int size;

    public QueueLinkedList() {
        // Inicializa uma fila vazia
        this.header = new ListNode(null, null, null); // nó sentinela do início
        this.trailer = new ListNode(null, header, null); // nó sentinela do final
        header.next = trailer; // liga os sentinelas
        this.size = 0; // tamanho inicial da fila
    }

    @Override
    public void enqueue(T elem) throws QueueFullException, NullNotAllowedException {
        if (elem == null) {
            throw new NullNotAllowedException("Null values are not allowed.");
        }
        // Cria um novo nó e insere no final da fila
        ListNode newNode = new ListNode(elem, trailer.prev, trailer);
        trailer.prev.next = newNode; // atualiza o nó anterior
        trailer.prev = newNode; // atualiza o trailer
        size++;
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty. Cannot dequeue.");
        }
        ListNode frontNode = header.next; // nó que será removido
        header.next = frontNode.next; // atualiza o header
        frontNode.next.prev = header; // atualiza o próximo nó
        size--;
        return frontNode.element; // retorna o elemento removido
    }

    @Override
    public T front() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty. Cannot access front.");
        }
        return header.next.element; // retorna o elemento na frente sem removê-lo
    }

    @Override
    public int size() {
        return size; // retorna o tamanho da fila
    }

    @Override
    public boolean isEmpty() {
        return size == 0; // verifica se a fila está vazia
    }

    @Override
    public void clear() {
        header.next = trailer; // reseta a fila ligando o header ao trailer
        trailer.prev = header; // liga o trailer de volta ao header
        size = 0; // redefine o tamanho
    }

    private class ListNode {
        private T element;
        private ListNode next;
        private ListNode prev;

        public ListNode(T element, ListNode prev, ListNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
