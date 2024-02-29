/**
 * Linked List Lab
 * Made by Toby Patterson 5/31/2020
 * For CS165 at CSU
 */

public class MyLinkedList<E> implements MiniList<E> {
    /*
     * Private member variables that you need to declare:
     ** The head pointer
     ** The tail pointer
     */

    private Node head;
    private Node tail;

    public class Node {
        // declare member variables (data, prev and next)
        private E data;
        private Node prev;
        private Node next;

        // finish these constructors
        public Node(E data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Node(E data) {
            this(data, null, null);
        } // HINT: use this() with next = prev = null
    }

    // Initialize the head and tail pointer
    public MyLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public boolean add(E item) {
        if (head == null) {
            head = new Node(item);
            tail = head;
        } else {
            Node temp = new Node(item, tail, null);
            tail.next = temp;
            tail = temp;
        }
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            Node temp = new Node(element, null, head);
            head.prev = temp;
            head = temp;
        } else if (index == size()) {
            add(element);
        } else {
            Node curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            Node temp = new Node(element, curr.prev, curr);
            curr.prev.next = temp;
            curr.prev = temp;
        }
    }

    @Override
    public E remove() {
        if (head == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        E temp = head.data;
        head = head.next;
        head.prev = null;
        return temp;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            return remove();
        } else if (index == size() - 1) {
            E temp = tail.data;
            tail = tail.prev;
            tail.next = null;
            return temp;
        } else {
            Node curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            E temp = curr.data;
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            return temp;
        }
    }

    @Override
    public boolean remove(E item) {
        Node curr = head;
        while (curr != null) {
            if (curr.data.equals(item)) {
                if (curr == head) {
                    remove();
                } else if (curr == tail) {
                    remove(size() - 1);
                } else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public boolean contains(E item) {
        Node curr = head;
        while (curr != null) {
            if (curr.data.equals(item)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    @Override
    public int indexOf(E item) {
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.data.equals(item)) {
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int size = 0;
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    // Uncomment when ready to test
    @Override
    public String toString() {
        String ret = "";
        Node curr = head;
        while (curr != null) {
            ret += curr.data + " ";
            curr = curr.next;
        }
        return ret;
    }

}