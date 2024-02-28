import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        InventoryNode headNode;
        InventoryNode currNode;
        InventoryNode lastNode;

        String item;
        int numberOfItems;
        int i;

        // Front of nodes list
        headNode = new InventoryNode();
        lastNode = headNode;

        int input = scnr.nextInt();

        for (i = 0; i < input; i++) {
            item = scnr.next();
            numberOfItems = scnr.nextInt();
            currNode = new InventoryNode(item, numberOfItems);
            currNode.insertAtFront(headNode, currNode);
            lastNode = currNode;
        }

        // Print linked list
        currNode = headNode.getNext();
        while (currNode != null) {
            currNode.printNodeData();
            currNode = currNode.getNext();
        }

        scnr.close();
    }
}
