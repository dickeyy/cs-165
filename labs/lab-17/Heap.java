import java.util.Arrays;

interface PriorityQueue<T extends Comparable<T>> {
    public void push(T item);

    public T pop();

    public T peek();
}

public class Heap<T extends Comparable<T>> implements PriorityQueue<T> {

    private T[] heap;
    private int size;

    public Heap(int capacity) {
        heap = (T[]) new Comparable[capacity];
    }

    /*
     * Given an index in the heap array, calculate what the parent node's
     * index is.
     */
    private int parent(int index) {

        // If the index is 0, it has no parent.
        if (index == 0) {
            return -1;
        }

        // If the index is odd, it's a right child.
        if (index % 2 == 1) {
            return (index - 1) / 2;
        }

        // If the index is even, it's a left child.
        return (index - 2) / 2;

    }

    /*
     * Given an index in the heap array, calculate what the right child's
     * index is.
     */
    private int rchild(int index) {

        // Calculate the right child's index.
        return 2 * index + 2;

    }

    /*
     * Given an index in the heap array, calculate what the left child's
     * index is.
     */
    private int lchild(int index) {

        // Calculate the left child's index.
        return 2 * index + 1;

    }

    private boolean hasLeftChild(int index) {

        // Check if the left child's index is within the bounds of the array.
        return lchild(index) < size;

    }

    private boolean hasRightChild(int index) {

        // Check if the right child's index is within the bounds of the array.
        return rchild(index) < size;

    }

    /*
     * Swap the items in the array at index1 and index2.
     */
    private void swap(int index1, int index2) {

        // Swap the items at the two indices.
        T temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;

    }

    /*
     * Perform a heapify starting at the given index.
     * Check the index's two children to see if you should swap the node
     * with either of these children. If you should, do the swap, and call
     * another bubbleDown on the index you swapped to.
     */
    private void bubbleDown(int index) {

        // If the index has no children, return.
        if (!hasLeftChild(index) && !hasRightChild(index)) {
            return;
        }

        // If the index has a left child but no right child, compare the index
        // with the left child.
        if (hasLeftChild(index) && !hasRightChild(index)) {
            if (heap[index].compareTo(heap[lchild(index)]) < 0) {
                swap(index, lchild(index));
                bubbleDown(lchild(index));
            }
            return;
        }

        // If the index has both children, compare the index with the left
        // child.
        if (heap[index].compareTo(heap[lchild(index)]) < 0) {
            swap(index, lchild(index));
            bubbleDown(lchild(index));
        }

        // Compare the index with the right child.
        if (heap[index].compareTo(heap[rchild(index)]) < 0) {
            swap(index, rchild(index));
            bubbleDown(rchild(index));
        }

    }

    /*
     * Perform a "reverse-heapify" starting at the current index.
     * Check the index's parent to see if you should swap the two; If you
     * should, do a swap and call another bubbleUp on the index you swapped to.
     *
     * This should be a significantly simpler method than bubbleDown.
     */
    private void bubbleUp(int index) {

        // If the index has no parent, return.
        if (parent(index) == -1) {
            return;
        }

        // If the index is greater than its parent, swap the two.
        if (heap[index].compareTo(heap[parent(index)]) > 0) {
            swap(index, parent(index));
            bubbleUp(parent(index));
        }

    }

    /*
     * Add an item to the queue.
     * Add the item at the end of the array, then bubble it up.
     * Assume that the heap will have space.
     */
    public void push(T item) {

        // Add the item to the end of the array.
        heap[size] = item;

        // Bubble the item up.
        bubbleUp(size);

        // Increment the size of the heap.
        size++;

    }

    /*
     * Remove the highest priority item from the queue.
     * Replace the item at the root (index 0) with the last item
     * in the array, then bubble it down.
     * Assume that the heap won't be empty.
     */
    public T pop() {

        // Save the item at the root.
        T item = heap[0];

        // Replace the root with the last item in the array.
        heap[0] = heap[size - 1];

        // Bubble the new root down.
        bubbleDown(0);

        // Decrement the size of the heap.
        size--;

        // Return the item that was at the root.
        return item;

    }

    /*
     * Return the highest priority item from the queue.
     */
    public T peek() {
        // Return the item at the root.
        return heap[0];
    }

    public String toString() {
        return Arrays.toString(heap);
    }

    public static void main(String[] args) {
        Heap<String> colors = new Heap<String>(10);

        colors.push("lime");
        System.out.println("push lime       -> " + colors);
        colors.push("fuchsia");
        System.out.println("push fuchsia    -> " + colors);
        colors.push("cyan");
        System.out.println("push cyan       -> " + colors);
        colors.push("yellow");
        System.out.println("push yellow     -> " + colors);
        colors.push("maroon");
        System.out.println("push maroon     -> " + colors);

        System.out.println();
        System.out.printf("pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf("pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf("pop %-12s<- " + colors + "\n", colors.pop());

        System.out.println();
        System.out.printf("peek %-11s<- " + colors + "\n", colors.peek());
        System.out.printf("peek %-11s<- " + colors + "\n", colors.peek());

        System.out.println();
        colors.push("olive");
        System.out.println("push olive      -> " + colors);
        colors.push("icterine");
        System.out.println("push icterine   -> " + colors);
        colors.push("sienna");
        System.out.println("push sienna     -> " + colors);
        colors.push("silver");
        System.out.println("push silver     -> " + colors);
        colors.push("teal");
        System.out.println("push teal       -> " + colors);
        System.out.printf("pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf("pop %-12s<- " + colors + "\n", colors.pop());
        colors.push("slate");
        System.out.println("push slate      -> " + colors);
        System.out.printf("pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf("peek %-11s<- " + colors + "\n", colors.peek());
        System.out.printf("pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf("peek %-11s<- " + colors + "\n", colors.peek());
        System.out.printf("pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf("pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf("pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf("pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf("peek %-11s<- " + colors + "\n", colors.peek());
    }

}
