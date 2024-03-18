import java.util.NoSuchElementException;

public class QueueLL<E> {
    private NodeGeneric<E> front;
    private NodeGeneric<E> back;
    private int size, capacity;

    public QueueLL(int capacity) {
        front = null;
        back = null;
        size = 0;
        this.capacity = capacity;
    }

    /**
     * public boolean offer (E elem)
     *
     * @param elem
     * @return boolean
     *         Add elem in queue if there is space.
     *         Return true if elem is added, false otherwise.
     */
    public boolean offer(E elem) {
        if (size == capacity) {
            return false;
        }
        NodeGeneric<E> node = new NodeGeneric<E>(elem);
        if (size == 0) {
            front = node;
            back = node;
        } else {
            back.setNext(node);
            back = node;
        }
        size++;
        return true;
    }

    /**
     * public boolean add(E elem)
     *
     * @param elem
     * @return boolean
     *         Call offer method to add elem.
     *         If it was not possible to add elem,
     *         throw IllegalState Exception.
     *         Return true otherwise.
     */

    public boolean add(E elem) {
        if (offer(elem)) return true;
        throw new IllegalStateException();
    }

    /**
     * public E pool
     *
     * @return E
     *         Remove element from the queue.
     *         Return elem or null if queue is empty.
     */

    public E pool() {
        if (size == 0) {
            return null;
        }
        E ret = front.getElement();
        front = front.getNext();
        size--;
        return ret;
    }

    /**
     * public E remove()
     *
     * @return E
     *         Call pool to remove an element from the queue.
     *         If it was not possible to remove,
     *         throw NoSuchElementException.
     *         Return element otherwise.
     */

    public E remove() {
        E ret = pool();
        if (ret == null) {
            throw new NoSuchElementException();
        }
        return ret;
    }

    /**
     * public E peek()
     *
     * @return E
     *         Return element from the queue.
     *         If queue is empty, return null.
     */

    public E peek() {
        if (size == 0) {
            return null;
        }
        return front.getElement();
    }

    /**
     * public E element()
     *
     * @return E
     *         Call peek, if there is no element
     *         throw NoSuchElementException.
     *         Return element otherwise.
     */
    public E element() {
        E ret = peek();
        if (ret == null) {
            throw new NoSuchElementException();
        }
        return ret;
    }

    public String toString() {
        String ret = "";
        NodeGeneric<E> node = front;
        while (node != null) {
            ret += node.getElement() + " ";
            node = node.getNext();
        }
        return ret;
    }

    public static void main(String[] args) {
        QueueLL<Integer> q = new QueueLL<Integer>(5);
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        System.out.println(q);
        System.out.println(q.offer(6));
        System.out.println(q);
        System.out.println(q.pool());
    }

}
