import java.util.Arrays;
import java.util.NoSuchElementException;

public class PriorityQueue {

    /* This class is finished for you. */
    public static class Customer implements Comparable<Customer> {
        private double donation;

        public Customer(double donation) {
            this.donation = donation;
        }

        public double getDonation() {
            return donation;
        }

        public void donate(double amount) {
            donation += amount;
        }

        public int compareTo(Customer other) {
            double diff = donation - other.donation;
            if (diff < 0) {
                return -1;
            } else if (diff > 0) {
                return 1;
            } else {
                return 0;
            }
        }

        public String toString() {
            return String.format("$%.2f", donation);
        }
    }

    private Customer[] data;
    private int size;

    public PriorityQueue(int capacity) {
        data = new Customer[capacity];
        size = 0;
    }

    public PriorityQueue() {
        this(10);
    }

    /*
     * Add a customer to the queue.
     * Remember to do so in a way that keeps the queue in sorted order!
     */
    public void push(Customer customer) {
        int index = size;
        while (index > 0 && customer.compareTo(data[index - 1]) > 0) {
            data[index] = data[index - 1];
            index--;
        }
        data[index] = customer;
        size++;
    }

    /*
     * Remove and return the highest priority customer from the queue.
     */
    public Customer pop() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        Customer customer = data[0];
        for (int i = 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return customer;
    }

    /*
     * Return, but don't remove, the highest priority item from the queue.
     */
    public Customer peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[0];
    }

    /*
     * Given the index of a customer, increase their donation amount, letting
     * them cut in line if necessary.
     *
     * Refer to the Customer class to remind yourself the operations you can do
     * on a customer.
     */
    public void bump(int customerIndex, double amount) {
        if (size == 0) {
            throw new NoSuchElementException("fart");
        }

        data[customerIndex].donate(amount);

        // Move the customer up the queue if necessary
        while (customerIndex > 0 && data[customerIndex].compareTo(data[customerIndex - 1]) > 0) {
            Customer temp = data[customerIndex];
            data[customerIndex] = data[customerIndex - 1];
            data[customerIndex - 1] = temp;
            customerIndex--;
        }
    }

    public String toString() {
        return Arrays.toString(data);
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        PriorityQueue line = new PriorityQueue(6);

        System.out.println("Testing push");

        line.push(new Customer(5.00));
        line.push(new Customer(10.00));
        line.push(new Customer(1.00));

        System.out.println("Line should be:\n[$10.00, $5.00, $1.00, null, null, null]");
        System.out.println(line);

        System.out.println("Line size should be 3 is: " + line.getSize());

        System.out.println();

        System.out.println("Testing pop");

        System.out.println(line.pop());
        System.out.println(line.pop());

        System.out.println();

        System.out.println("Testing bump");

        line.push(new Customer(20.00));
        line.push(new Customer(15.00));
        line.push(new Customer(2.00));

        line.bump(1, 30.00);
        line.bump(3, 60.00);
        System.out.println(line.pop());
        System.out.println(line.peek());
        System.out.println(line.pop());
        System.out.println(line.pop());
        System.out.println(line.pop());

        System.out.println();

        line.push(new Customer(7.00));
        line.push(new Customer(8.00));
        line.push(new Customer(9.00));
        line.push(new Customer(7.00));
        line.push(new Customer(10.00));

        System.out.println("Line should be:\n[$10.00, $9.00, $8.00, $7.00, $7.00, null]");
        System.out.println(line);

    }
}
