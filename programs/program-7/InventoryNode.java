public class InventoryNode {
    private String item;
    private int numberOfItems;
    private InventoryNode nextNodeRef; // Reference to the next node

    public InventoryNode() {
        item = "";
        numberOfItems = 0;
        nextNodeRef = null;
    }

    // Constructor
    public InventoryNode(String itemInit, int numberOfItemsInit) {
        this.item = itemInit;
        this.numberOfItems = numberOfItemsInit;
        this.nextNodeRef = null;
    }

    // Constructor
    public InventoryNode(String itemInit, int numberOfItemsInit, InventoryNode nextLoc) {
        this.item = itemInit;
        this.numberOfItems = numberOfItemsInit;
        this.nextNodeRef = nextLoc;
    }

    // front of the linked list (after the dummy head node)
    public void insertAtFront(InventoryNode head, InventoryNode newNode) {
        newNode.nextNodeRef = head.nextNodeRef;
        head.nextNodeRef = newNode;
    }

    // Get location pointed by nextNodeRef
    public InventoryNode getNext() {
        return this.nextNodeRef;
    }

    // Print node data
    public void printNodeData() {
        System.out.println(this.numberOfItems + " " + this.item);
    }
}