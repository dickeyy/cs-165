import java.util.*;

public class LinkedQueue implements MyQueue {

    public class Node {
        String name;
        Node next;

        public Node(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private Node head;
    private Node tail;
    private final int maxCount;
    private int size;

    /*
     * TODO FINISH ME
     * The Constructor should set maxCount to the maximum amount of customers for
     * the day
     * also make sure to initialize size
     * 
     * @param maxCount
     */
    public LinkedQueue(int maxCount) {
        this.maxCount = maxCount;
        size = 0;
    }

    /**
     * TODO FINISH ME
     * This method should add a new Node with the person's name at the
     * end of the Queue. This method should also check if the Queue
     * is full(size of Queue > maxCount) and throw an exception if
     * the Queue is full
     *
     * @param name - person to add
     * @return true if item can be added
     * @throws IllegalStateException if the Queue is full
     *                               element cannot be added because it is a
     *                               duplicate
     */
    @Override
    public boolean add(String name) {
        if (size >= maxCount) {
            throw new IllegalStateException("Queue is full");
        }
        Node newNode = new Node(name);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * TODO FINISH ME
     * This method is the same as add EXCEPT that it simply returns
     * false if the item can't be inserted instead of throwing an exception
     *
     * @param name
     * @return true if item can be inserted, false otherwise
     */
    @Override
    public boolean offer(String name) {
        if (size >= maxCount) {
            return false;
        }
        Node newNode = new Node(name);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * TODO FINISH ME
     * returns the name of the element at the head of the Queue but do
     * NOT remove it
     *
     * @return Element at the head of the Queue
     * @throws NoSuchElementException if the Queue is empty
     */
    @Override
    public String element() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.name;
    }

    /**
     * TODO FINISH ME
     * This method is the same as element except for the fact that it
     * doesn't throw an exception
     *
     * @return the head of the Queue, or null if the Queue is empty
     */
    @Override
    public String peek() {
        if (head == null) {
            return null;
        }
        return head.name;
    }

    /**
     * TODO FINISH ME
     * removes and returns the name of the element at the head of the Queue
     *
     * @return the name of element at the head of the Queue, or null if Queue is
     *         empty
     */
    @Override
    public String poll() {
        if (head == null) {
            return null;
        }
        String ret = head.name;
        head = head.next;
        size--;
        return ret;
    }

    /**
     * TODO FINISH ME
     * This method is the same as poll() except that it throws an exception if the
     * Queue
     * is empty
     *
     * @return the name of the element at the head of the Queue
     * @throws NoSuchElementException if the Queue is empty
     */
    @Override
    public String remove() {
        if (head == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        String ret = head.name;
        head = head.next;
        size--;
        return ret;
    }

    /**
     * TODO FINISH ME
     * Returns true if the Queue contains a node with the same name that was passed
     * in
     *
     * @param name
     * @return true if Queue contains the item, false if not
     */
    @Override
    public boolean contains(String name) {
        Node cur = head;
        while (cur != null) {
            if (cur.name.equals(name)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * TODO FINISH ME
     * 
     * @return The current number of items in the string
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String retString = "";
        Node cur = head;
        while (cur != null) {
            retString += String.format("%s ", cur.name);
            cur = cur.next;
        }
        return retString;
    }

    // DO NOT MODIFY THE FOLLOWING METHOD!
    public String simulateBooth() {
        LinkedQueue queue = new LinkedQueue(10);
        double money = 0;
        float priceOfCone = 1.25f;
        // add people to queue
        queue.add("John");
        queue.add("James");
        queue.add("Charlie");
        queue.add("Michelle");
        queue.add("Darius");
        queue.add("Daniel");
        queue.add("Lisa");
        queue.add("Bart");
        queue.add("James");
        // print queue
        System.out.printf("There are %d items in the queue\n", queue.size());
        // serve customer and increment cash
        int numCustomers = queue.size();
        String cur = queue.poll();
        while (cur != null) {
            System.out.printf("The Ice Cream stall served %s ice cream\n", cur);
            money += priceOfCone;
            cur = queue.poll();
        }

        return ("The Ice Cream booth made $" + money + " and served " + numCustomers + " people");
    }

    public static void myAssert(boolean b) {
        if (!b)
            throw new RuntimeException();
    }

    public static void main(String[] arg) {

        System.out.println("Testing Methods It will stop running the program if there is an issue and let you know\n");

        LinkedQueue q1 = new LinkedQueue(4);

        System.out.println("Testing Add:");
        if (!q1.add("1")) {
            System.err.println("ERROR: Add did not return True");
            System.exit(1);
        }
        q1.add("2");
        q1.add("3");
        q1.add("4");
        myAssert(q1.toString().equals("1 2 3 4 "));
        try {
            q1.add("Darius");
            System.err.println("ERROR: add adds Elements past max Size");
            System.exit(1);
        } catch (IllegalStateException e) {
        } catch (Exception e) {
            System.err.println("ERROR: Caught the wrong excpetion");
            System.exit(1);
        }
        System.out.println("Add Looks Good");

        System.out.println("\n");

        System.out.println("Testing Offer:");
        LinkedQueue q2 = new LinkedQueue(4);
        if (!q2.offer("1")) {
            System.err.println("ERROR: Offer did not return True");
            System.exit(1);
        }
        q2.offer("2");
        q2.offer("3");
        q2.offer("4");
        myAssert(q2.toString().equals("1 2 3 4 "));

        if (q2.offer("Darius")) {
            System.err.println("ERROR: offer adds Elements past max Size");
            System.exit(1);
        }

        System.out.println("Offer Looks Good");

        System.out.println("\n");

        System.out.println("Testing Element:");

        LinkedQueue q3 = new LinkedQueue(4);
        try {
            q3.element();
            System.err.println("ERROR: element on an empty list did not throw an exception");
            System.exit(1);
        } catch (NoSuchElementException e) {
        } catch (Exception e) {
            System.err.println("ERROR: caught wrong exception");
            System.exit(1);
        }
        q3.add("1");
        myAssert(q3.element().equals("1"));
        myAssert(q3.toString().equals("1 "));
        System.out.println("Element Looks good");

        System.out.println("\n");

        System.out.println("Testing Peek:");

        LinkedQueue q4 = new LinkedQueue(4);

        if (q4.peek() != null) {
            System.err.println("ERROR: peek on an empty list did not return null");
            System.exit(1);
        }

        q4.add("1");
        myAssert(q4.element().equals("1"));
        myAssert(q4.toString().equals("1 "));
        System.out.println("Peek Looks good");

        System.out.println("\n");

        System.out.println("Testing Poll:");
        LinkedQueue q5 = new LinkedQueue(4);
        q5.offer("Joe");
        q5.add("Jim");
        String name = q5.poll();
        myAssert(name.equals("Joe"));
        String n = q5.poll();
        myAssert(n.equals("Jim"));
        String name2 = q5.poll();
        myAssert(name2 == null);
        System.out.println("Poll Looks good");
        System.out.println("\n");

        System.out.println("Testing Remove");
        LinkedQueue q6 = new LinkedQueue(4);
        try {
            q6.remove();
        } catch (NoSuchElementException e) {

        } catch (Exception e) {
            System.err.println("ERROR: caught wrong exception");
            System.exit(1);
        }
        q6.add("1");
        q6.add("2");
        myAssert("1".equals(q6.remove()));
        myAssert(q6.toString().equals("2 "));
        System.out.println("Remove looks good");

        System.out.println("\n");
        LinkedQueue q7 = new LinkedQueue(4);
        q7.offer("Joe");
        // test contains
        System.out.println("Testing Contains:");
        myAssert(q7.contains("Joe"));
        myAssert(!q7.contains("Jim"));
        myAssert(!new LinkedQueue(2).contains("Bob"));
        System.out.println("Contains Looks good");

        // test size
        System.out.println("\n");
        System.out.println("Testing Size:");
        LinkedQueue q8 = new LinkedQueue(4);
        myAssert(q8.size() == 0);
        q8.add("1");
        myAssert(q8.size() == 1);
        q8.offer("1");
        myAssert(q8.size() == 2);
        q8.element();
        myAssert(q8.size() == 2);
        q8.peek();
        myAssert(q8.size() == 2);
        q8.remove();
        myAssert(q8.size() == 1);
        q8.poll();
        myAssert(q8.size() == 0);
        q8.poll();
        myAssert(q8.size() == 0);

        System.out.println("Size Looks good");

        // //UNCOMMENT WHEN YOU HAVE TESTED ALL OTHER CODE
        LinkedQueue queue = new LinkedQueue(4);
        System.out.println("\n\n\n");
        System.out.println(queue.simulateBooth());
    }
}
