package data_structures.queue;

public interface Queue<T> {

    /**
     * Adds an elem element to the end of the queue.
     * If the item is successfully added, returns true, otherwise - false.
     */
    void offer(T elem);

    /**
     * @return with removal the element from the beginning of the queue.
     * If the queue is empty, returns NULL
     */
    T poll();

    /**
     * @return without deleting an element from the front of the queue.
     * If the queue is empty, returns null
     */
    T peek();

    int size();

    boolean isEmpty();
}
