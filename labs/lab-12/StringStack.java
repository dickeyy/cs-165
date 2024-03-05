import java.util.*;

/* YOUR CODE HERE
 * This entire class is just a skeleton for your code, plus a main method
 * for testing.
 */
public class StringStack {

    /*
     * You will need some data fields here - at the very least, some kind of
     * String array. You may also want to keep track of the size of the stack, i.e.
     * the number of elements in the stack.
     * REMEMBER: Capacity is how much the stack can hold, and size is the number of
     * elements it contains.
     */
    String[] stack;
    int size;

    /*
     * Puts the stack into a valid state, ready for us to call methods on.
     * This constructor will create a stack with a different capacity than the
     * default.
     */
    public StringStack(int capacity) {
        stack = new String[capacity];
        size = 0;
    }

    /*
     * If someone calls the constructor with no argument, they should get a
     * stack with a default capacity of 10.
     */
    public StringStack() {
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
     */
    public String peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return stack[size - 1];
    }

    public String pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        String top = stack[size - 1];
        stack[size - 1] = null;
        size--;
        return top;
    }

    /*
     * Add a new object to the top of the stack.
     * If there is no room in the stack, throw a IllegalStateException.
     */
    public String push(String s) {
        if (size == stack.length) {
            throw new IllegalStateException();
        }
        stack[size] = s;
        size++;
        return s;
    }

    /*
     * Return the position of an object on the stack. The position of an object
     * is just its distance from the top of the stack. So, the topmost item is
     * distance 0, the one below the topmost item is at distance 1, etc.
     * If the item is not found, return -1.
     */
    public int search(String s) {
        for (int i = size - 1; i >= 0; i--) {
            if (stack[i].equals(s)) {
                return size - i - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StringStack stack_ten = new StringStack();
        StringStack stack_three = new StringStack(3);

        assertEquals(stack_ten.empty(), true,
                "Your stack returned false for empty(), even though it was just "
                        + "created and should be empty.");

        stack_ten.push("Alef");
        stack_ten.push("Bet");
        stack_ten.push("Gimel");

        assertEquals(stack_ten.empty(), false,
                "Your stack returned true for empty(), even though elements were "
                        + "pushed into it.");

        String top = stack_ten.pop();
        assertEquals(top, "Gimel",
                "Didn't get the correct element from a pop()! Should have been \" "
                        + "Gimel\", but was \"" + top + "\".");

        top = stack_ten.peek();
        assertEquals(top, "Bet",
                "Didn't get the correct element from a peek()! Should have been "
                        + "\"Bet\", but was \"" + top + "\".");

        // Making sure a peek doesn't change anything!
        top = stack_ten.peek();
        assertEquals(top, "Bet",
                "Didn't get the correct element from a peek()! Should have been "
                        + "\"Bet\", but was \"" + top + "\".");

        stack_ten.pop();
        stack_ten.pop();

        assertEquals(stack_ten.empty(), true,
                "Your stack returned false for empty, even though all of its "
                        + "elements were popped off.");

        boolean caught = false;
        try {
            stack_ten.pop();
        } catch (NoSuchElementException e) {
            caught = true;
        }
        if (!caught) {
            throw new AssertionError(
                    "Popping an empty stack should have caused a "
                            + "NoSuchElementException, but it did not!");
        }
        caught = false;
        try {
            stack_ten.peek();
        } catch (NoSuchElementException e) {
            caught = true;
        }
        if (!caught) {
            throw new AssertionError(
                    "Peeking an empty stack should have caused a "
                            + "NoSuchElementException, but it did not!");
        }
        caught = false;

        String[] moreLetters = new String[] {
                "Dalet", "He", "Vav", "Zayin", "Het", "Tet", "Yod", "Kaf", "Lamed"
        };
        for (String l : moreLetters) {
            stack_ten.push(l);
        }

        int searched = stack_ten.search("Het");
        assertEquals(searched, 4,
                "Incorrect result from .search(): got " + searched
                        + ", but should have found 4");

        searched = stack_ten.search("Lamed");
        assertEquals(searched, 0,
                "Incorrect result from .search(): got " + searched
                        + ", but should have found 0");

        searched = stack_ten.search("Not in the stack!");
        assertEquals(searched, -1,
                "Incorrect result from .search(): got " + searched
                        + ", but should have found -1");

        stack_three.push("A");
        stack_three.push("B");
        stack_three.push("G");
        try {
            stack_three.push("D");
        } catch (IllegalStateException e) {
            caught = true;
        }
        if (!caught) {
            throw new AssertionError(
                    "Trying to push onto a full stack should have caused an "
                            + "IllegalStateException, but it did not.");
        }

        System.out.println("All tests passed! Now go play some Jenga, because "
                + "you're the stacking master.");
    }

    private static <T1, T2> void assertEquals(T1 e1, T2 e2, String msg) {
        if (!e1.equals(e2)) {
            throw new AssertionError(msg);
        }
    }
}