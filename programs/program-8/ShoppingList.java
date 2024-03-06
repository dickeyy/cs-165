import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        ItemNode headNode; // Create intNode objects
        ItemNode currNode;
        ItemNode lastNode;

        String item;
        int i;

        // Front of nodes list
        headNode = new ItemNode();
        lastNode = headNode;

        int input = scnr.nextInt();

        for (i = 0; i < input; i++) {
            item = scnr.next();
            currNode = new ItemNode(item);
            lastNode.insertAtEnd(headNode, currNode);
            lastNode = currNode;
        }

        // Print linked list
        currNode = headNode.getNext();
        while (currNode != null) {
            currNode.printNodeData();
            currNode = currNode.getNext();
        }
    }
}