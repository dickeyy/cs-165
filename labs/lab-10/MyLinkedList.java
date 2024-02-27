/**
 * Linked List Lab
 * Made by Toby Patterson 5/29/2020
 * For CS165 at CSU
 */

public class MyLinkedList implements MiniList<Integer> {
    /*
     * Private member variables that you need to declare:
     ** The head pointer
     ** The tail pointer
     */
    private Node head;
    private Node tail;

    public class Node {
        // declare member variables (data and next)
        public int data;
        public Node next;

        // finish these constructors
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this(data, null);
        }
    }

    // Initialize the linked list (set head and tail pointers)
    public MyLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public boolean add(Integer item) {
        // add items, handle duplicates
        if (head == null) {
            head = new Node(item);
            return true;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(item);
        return true;
    }

    @Override
    public void add(int index, Integer element) {
        if (index == 0) {
            head = new Node(element, head);
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = new Node(element, curr.next);
        }
    }

    @Override
    public Integer remove() {
        if (head == null) {
            return null;
        }
        int ret = head.data;
        head = head.next;
        return ret;
    }

    @Override
    public Integer remove(int index) {
        if (index == 0) {
            int ret = head.data;
            head = head.next;
            return ret;
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            int ret = curr.next.data;
            curr.next = curr.next.next;
            return ret;
        }
    }

    @Override
    public boolean remove(Integer item) {
        if (head == null) {
            return false;
        }
        if (head.data == item) {
            head = head.next;
            return true;
        }
        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == item) {
                curr.next = curr.next.next;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean contains(Integer item) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == item) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public Integer get(int index) {
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    @Override
    public int indexOf(Integer item) {
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.data == item) {
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
        Node curr = head;
        int size = 0;
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