import java.util.*;

/* YOUR CODE HERE
 * This entire class is just a skeleton for your code, plus a main method
 * for testing.
 */
public class GenericStack {

    private String[] stack;
    private int size;

    /*
     * Puts the stack into a valid state, ready for us to call methods on.
     * The capacity parameter tells how many elements the stack can hold.
     */
    public GenericStack(int capacity) {

        this.stack = new String[capacity];
        this.size = 0;

    }

    /*
     * If someone calls the constructor with no argument, they should get a
     * stack with a default capacity of 10.
     */
    public GenericStack() {

        this(10);

    }

    /*
     * Return true if the stack has no elements, and false otherwise.
     */
    public boolean empty() {
        return size == 0;
    }

    /*
     * Return the object at the top of the stack, WITHOUT removing it.
     * If there are no elements to peek, throw a NoSuchElementException.
     * Update this method so that it can return a generic element.
     */
    public String peek() {

        // If the stack is empty, throw a NoSuchElementException
        if (empty()) {
            throw new NoSuchElementException();
        } else {
            return stack[size - 1];
        }

    }

    /*
     * Return the object at the top of the stack, AND ALSO remove it.
     * If there are no elements to pop, throw a NoSuchElementException.
     * Update this method so that it can return a generic element.
     */
    public String pop() {

        // If the stack is empty, throw a NoSuchElementException
        if (empty()) {
            throw new NoSuchElementException();
        } else {
            String temp = stack[size - 1];
            stack[size - 1] = null;
            size--;
            return temp;
        }
    }

    /*
     * Add a new object to the top of the stack.
     * If there is no room in the stack, throw a IllegalStateException.
     * Update this method so that it can return a generic element.
     * What should the parameter be?
     */
    public String push(String s) {
        if (size == stack.length) {
            throw new IllegalStateException();
        } else {
            stack[size] = s;
            size++;
            return s;
        }
    }

    /*
     * Return the position of an object on the stack. The position of an object
     * is just its distance from the top of the stack. So, the topmost item is
     * distance 0, the one below the topmost item is at distance 1, etc.
     * What should the parameter be?
     */
    public int search(String s) {
        for (int i = size - 1; i >= 0; i--) {
            if (stack[i].equals(s)) {
                return size - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // If any of these lines cause a compilation error, your stack hasn't
        // been properly made generic.
        GenericStack<Integer> intStack = new GenericStack<>();
        GenericStack<String> stringStack = new GenericStack<>();
        GenericStack<ArrayList<String>> listStack = new GenericStack<>();

        // If any of the code below produces an error message, you have not
        // implemented the stack correctly. Your stack must be able to hold
        // and handle null values.
        // For more tests, either write your own or refer to Lab 11.

        intStack.push(null);
        intStack.push(5);
        intStack.push(511);
        intStack.push(null);

        if (intStack.size != 4) {
            System.out.println("Error: Values were incorrectly pushed onto"
                    + " your stack. \n Your stack should have size 4, but has "
                    + "size " + intStack.size + ". \n Check that your stack "
                    + "accepts null values.");
        }
        if (intStack.peek() != null) {
            System.out.println("Error: Calling peek on a stack that had null "
                    + "pushed to \n the top should have returned null, but "
                    + "returned " + intStack.peek() + ".");
        }
        try {
            intStack.search(null);
        } catch (NullPointerException e) {
            System.out.println("Error: When called, search(null) should have "
                    + "returned 0, but it \n caused an error. Recall that "
                    + "functions, such as equals(),\n cannot be called on a "
                    + "null value.");

        }
        Integer popped = intStack.pop();
        if (popped != null) {
            System.out.println("Error: calling pop() should have returned null"
                    + " when a null value was at the top of the stack, but instead"
                    + "it returned " + popped + ".");
        }

    }

}
