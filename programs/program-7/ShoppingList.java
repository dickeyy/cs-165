import java.util.Scanner;
import java.util.LinkedList;

public class ShoppingList {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        LinkedList<ListItem> shoppingList = new LinkedList<ListItem>();
        String item;

        // Read inputs until a -1 is input
        while (true) {
            item = scnr.nextLine();
            if (item.equals("-1")) {
                break;
            }
            shoppingList.add(new ListItem(item));
        }

        for (ListItem listItem : shoppingList) {
            listItem.printNodeData();
        }

        scnr.close();

    }
}