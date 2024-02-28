public class Worksheet {

    /*
     * 1. a
     * 2. a
     * 3. a
     * 4. b
     * 5. a
     * 6. c
     * 7. b
     * 8. a
     * 9. a
     * 10. c
     * 11. c
     * 12. c
     * 13. c
     * 14. c
     * 15. a
     * 16. a
     * 17. d
     * 18. d
     * 19. ...
     */

    private DLLNode head;

    // Constructor
    public Worksheet() {
        head = new DLLNode(null); // Creating a head node
    }

    // Method to remove a node with value s
    public void remove(String s) {
        DLLNode current = head.getNext(); // Start from the first node after the head
        while (current != head) { // Loop until we reach back to the head
            if (current.getItem().equals(s)) { // If we find the node with the value s
                current.getPrev().setNext(current.getNext()); // Update previous node's next pointer
                current.getNext().setPrev(current.getPrev()); // Update next node's previous pointer
                return; // Exit the method after removal
            }
            current = current.getNext(); // Move to the next node
        }
        System.err.println("Error: Node with value " + s + " not found!"); // If the node with value s is not found
    }

    // Inner class for DLLNode
    private class DLLNode {
        private DLLNode prev;
        private DLLNode next;
        private String item;

        // Constructor with prev and next
        private DLLNode(DLLNode p, DLLNode n, String s) {
            prev = p;
            next = n;
            item = s;
        }

        // Constructor for circularly linked single item list
        private DLLNode(String s) {
            item = s;
            this.next = this;
            this.prev = this;
        }

        // Getters and Setters
        private void setNext(DLLNode n) {
            next = n;
        }

        private DLLNode getNext() {
            return next;
        }

        private void setPrev(DLLNode p) {
            prev = p;
        }

        private DLLNode getPrev() {
            return prev;
        }

        private String getItem() {
            return item;
        }
    }

}
