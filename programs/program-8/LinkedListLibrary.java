public class LinkedListLibrary {
    // Linked list nodes
    BookNode headNode;
    BookNode lastNode;

    LinkedListLibrary() {
        // Front of nodes list
        headNode = new BookNode();
        lastNode = headNode;
    }

    public int insertSorted(BookNode newNode, int counter) {
        BookNode currNode, nextNode;

        // Special case for head node
        if (headNode == null || headNode.getBookISBN() >= newNode.getBookISBN()) {
            newNode.insertAfter(headNode);
            headNode = newNode;
        } else {
            // Locate the node before insertion point
            currNode = headNode;

            while (currNode.getNext() != null && currNode.getNext().getBookISBN() < newNode.getBookISBN()) {
                currNode = currNode.getNext();
            }
            newNode.setNext(currNode.getNext());
            currNode.insertAfter(newNode);
        }

        ++counter;
        return counter;
    }

    public void printLibrary() {
        BookNode currNode;

        currNode = headNode.getNext();
        while (currNode != null) {
            currNode.printBookInfo();
            System.out.println();
            currNode = currNode.getNext();
        }
    }
}