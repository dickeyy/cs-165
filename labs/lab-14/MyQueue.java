import java.util.NoSuchElementException;

public interface MyQueue{
    /**
     * This method should add a new Node with the person's name at the
     * end of the Queue. This method should also check if the Queue
     * is full(size of Queue == maxCount) and throw an exception if
     * the Queue is full
     * @param name - person to add
     * @return true if item can be added
     * @throws IllegalStateException if the Queue is full
     * element cannot be added because it is a duplicate
     */
    boolean add(String name);

    /**
     * This method is the same as add EXCEPT that it simply returns
     * false if the item can't be inserted instead of throwing an exception
     * @param name
     * @return true if item can be inserted, false otherwise
     */
    boolean offer(String name);
    /**
     * returns the name of the element at the head of the Queue but do
     * NOT remove it
     * @return Element at the head of the Queue
     * @throws NoSuchElementException if the Queue is empty
     */
    String element();

    /**
     * This method is the same as element except for the fact that it
     * doesn't throw an exception
     *
     * @return the head of the Queue, or null if the Queue is empty
     */
    String peek();
    /**
     * removes and returns the name of the element at the head of the Queue
     * @return the name of element at the head of the Queue, or null if Queue is empty
     */
    String poll();
    /**
     * This method is the same as poll() except that it throws an exception if the Queue
     * is empty
     * @return the name of the element at the head of the Queue
     * @throws NoSuchElementException if the Queue is empty
     */
    String remove();

    /**
     * Returns true if the Queue contains a node with the same name that was passed in
     * @param name
     * @return true if Queue contains the item, false if not
     */
    boolean contains(String name);

    /**
     * @return The current number of items in the string
     */
    int size();
}
