import java.util.NoSuchElementException;

/**
 * created by {@code cspfrederick} and {@code garethhalladay} Fall17 <br>
 * inspired by Chris Wilcox
 */
public interface IQueue<E> {
    /**
     * Inserts the specified element into this queue,
     * returning true upon success.
     * <p>
     * This method throws an IllegalStateException if no space is available to hold the new item.
     * @param item the item to add
     * @throws IllegalStateException if the queue is full
     */
    void add(E item);


    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions.
     * @param e the element to add
     * @return true if the element was added, false if the queue was full
     */
    boolean offer(E e);

    /**
     * Retrieves and removes the head of this queue.
     * @return the head of this queue, or null if this queue is empty
     */
    E poll();

    /**
     * Retrieves and removes the head of this queue.
     * This method differs from poll only in that it throws an exception
     * if this queue is empty.
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E remove();

    /**
     * Retrieves, but does not remove, the head of this queue.
     * @return the head of this queue, or null if this queue is empty
     */
    E peek();

    /**
     * Retrieves, but does not remove, the head of this queue.
     * This method differs from peek only in that it throws an
     * exception if this queue is empty.
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    E element();

    /**
     * Returns true if this queue contains no elements.
     * @return true if this queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this queue.
     * @return the number of elements in the queue
     */
    int size();

    /**
     * Removes all of the elements from this queue.
     * The queue will be empty after this call returns.
     */
    void clear();

    /**
     * Returns a string representation of this queue.
     * The string representation consists of a list of the
     * queue's elements in the order they are returned by its iterator,
     * enclosed in square brackets ("[]"). Adjacent elements are separated
     * by the characters ", " (comma and space). Elements are converted to
     * strings as by String.valueOf(Object).
     * @return a string representation of this queue
     */
    @Override
    String toString();

    /**
     * Returns true if this queue contains the specified element. More formally,
     * returns true if and only if this queue contains at least one element e
     * such that o.equals(e).
     * @param o object to be checked for containment in this queue
     * @return true if this queue contains the specified element, false otherwise
     */
    boolean contains(Object o);
}
