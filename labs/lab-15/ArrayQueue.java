import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayQueue is a FIFO (First In First Out) data structure that stores its
 * elements
 * in an array (or something like it, like an {@link java.util.ArrayList}).
 * <p>
 * Can we use an {@link java.util.ArrayList} to directly represent a queue? A
 * FIFO needs to push on one end,
 * and pop from the other. The tail of an {@link java.util.ArrayList} can
 * support pop and push efficiently,
 * but the front supports neither efficiently.
 * <p>
 * Instead, we use an array for storage, and we represent the head and tail of
 * the queue
 * with indices into that array. When one of the indices would fall off the end
 * of the array,
 * it just goes back to the start of the array. That is why this pattern is
 * called a "circular"
 * array. Read more about that <a href=../queue.html>here</a>.
 * <p>
 * We can think of the head and tail indices "chasing" each other around the
 * circular
 * storage. When you add an item, the tail moves. When you take an item, the
 * head moves.
 * If the head catches the tail, the queue is empty. If the tail catches the
 * head, the queue is full.
 * <p>
 * That's a lot to take in, but it's easier to code than it sounds. Notice that
 * the member variables
 * "removed" and "added" are counters recording the <i>total</i> operation
 * count. To see where the head and
 * tail of the queue are, just compute:
 * {@code (removed % elements.length)} or {@code (added % elements.length)}
 * <p>
 * by {@code cspfrederick} and {@code garethhalladay} Fall17 <br>
 * inspired by Chris Wilcox
 * 
 * @param <E> the type of elements held in this collection
 */
public class ArrayQueue<E> extends AQueue<E> implements IQueue<E> {

    /**
     * the underlying array for the queue
     */
    protected E[] elements;

    /**
     * the total elements added (set back to zero if clear is called)
     */
    protected int added = 0;

    /**
     * the total elements removed (set back to zero if clear is called)
     */
    protected int removed = 0;

    /**
     * Creates a new queue backed by an array of length {@code maxSize}.
     * Use {@link #newArray(int)} to create the elements array.
     * 
     * @param maxSize the capacity of the queue
     * @see #newArray(int)
     */
    public ArrayQueue(int maxSize) {
        elements = newArray(maxSize);
    }

    /**
     * A helper method to create a new array of the generic type.
     * Read the information provided on <a href=../generics.html>generics</a>.
     * It walks you through the behavior of this small method.
     * 
     * @param size the size of the new array
     * @return an new instance of an array of type E
     */
    protected E[] newArray(int size) {
        return (E[]) new Object[size];
    }

    /**
     * Adds an element to the queue. If the queue is full, return false,
     * otherwise add to the next available position in the queue.
     * <p>
     * The index of the next available position can be found by calculating
     * the remainder of the total number of elements added by the length of the
     * array.
     * <p>
     * Don't forget to increment the added field!
     * 
     * @param e the element to add
     * @return true if the element can be added, false otherwise
     * @see #added
     */
    @Override
    public boolean offer(E e) {

        if (size() == elements.length) {
            return false;
        }
        elements[added % elements.length] = e;
        added++;
        return true;

    }

    /**
     * Removes the oldest element (the head) from the queue, and returns it.
     * If the queue is empty, return null.
     * <p>
     * The index of the oldest element can be determined by calculating the
     * remainder
     * of the total elements removed by the length of the array.
     * <p>
     * Don't forget to increment the removed field!
     * <p>
     * 
     * @return the oldest element in the queue, or null if the queue is empty
     * @see #removed
     */
    @Override
    public E poll() {
        if (size() == 0) {
            return null;
        }
        E temp = elements[removed % elements.length];
        elements[removed % elements.length] = null;
        removed++;
        return temp;
    }

    /**
     * Returns the oldest element in the queue (the element we would remove next),
     * but does not remove it.
     * If the queue is empty, return null.
     * <p>
     * The index of the oldest element can be determined by calculating the
     * remainder
     * of the total elements removed by the length of the array.
     * 
     * @return the oldest element in the array, or null if the queue is empty
     */
    @Override
    public E peek() {
        if (size() == 0) {
            return null;
        }
        return elements[removed % elements.length];
    }

    /**
     * @return the difference between the total items added and removed
     */
    @Override
    public int size() {
        return added - removed;
    }

    /**
     * Clears the queue.
     * <p>
     * Reset the count for added and removed. Also, either set all slots in
     * the backing array to null, or reallocate a fresh array.
     * <p>
     * Why is this second step desirable? Why not just reset added and removed and
     * call it done?
     * 
     * @see #newArray(int)
     */
    @Override
    public void clear() {
        added = 0;
        removed = 0;
        elements = newArray(elements.length);
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size(); i++) {
            if (elements[(removed + i) % elements.length].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IQueue<Integer> q = new ArrayQueue<>(10);

        System.out.println("Offering to Queue:");
        System.out.println("     Offer(1) -> " + q.offer(1));
        System.out.println("     Offer(2) -> " + q.offer(2));
        System.out.println("     Offer(3) -> " + q.offer(3));
        System.out.println("     size() should be 3 -> " + q.size());
        System.out.println("     contains(2) should be true -> " + q.contains(2));

        System.out.println("Adding more elements using add():");
        System.out.println("     add(4);  add(5); add(6); add(7); add(8); add(9); add(10);");
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        System.out.println("     size() should be 10 -> " + q.size());

        System.out.println("Trying to offer to a full queue:");
        System.out.println("     offer(11) should return false -> " + q.offer(11));
        System.out.println("     size() should still be 10 -> " + q.size());

        System.out.println("Polling and removing some elements:");
        System.out.println("     poll() should be 1 -> " + q.poll());
        System.out.println("     remove() should be 2 -> " + q.remove());
        System.out.println("Testing clear:");
        q.clear();
        System.out.println("     size() should be 0 -> " + q.size());

        System.out.println("Trying to poll from an empty queue:");
        System.out.println("     poll() should return null -> " + q.poll());
        System.out.println("     size() should still be 0 -> " + q.size());

        System.out.println("Testing contains() with TrainCar objects:");
        ArrayQueue<TrainCar> qCar = new ArrayQueue<>(10);
        qCar.offer(new TrainCar("Engine", "orange", 80523));
        qCar.offer(new TrainCar("Passenger", "blue", 24601));
        qCar.offer(new TrainCar("Caboose", "red", 12345));
        TrainCar toTest = new TrainCar("Caboose", "red", 12345);
        System.out.println("     contains(" + toTest + ") should be true -> " + qCar.contains(toTest));
        System.out.println();

        // final testing uncomment the following line to get comprehensive testing.
        // Note: zyBooks is not able to run 100000 tests or more.
        final int hundred_thousand = 100000;
        final int million = 1000000;

        // QueueTestProgram.printFailedTests(million,
        // ArrayBlockingQueue::new,

        // ArrayQueue::new);

    }
}
