package data_structures.stack;

public interface Stack<T> {

    /**
     * Adds an elem element to stack.
     */
    void push(T elem);

    /**
     * @return with removal the element from the stack.
     * If the queue is empty, returns NULL
     */
    T pop();

    /**
     * @return without deleting an element from the stack.
     * If the queue is empty, returns null
     */
    T peek();

    int size();

    boolean isEmpty();
}