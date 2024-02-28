public class ListItem {
    private String item;

    public ListItem() {
        item = "";
    }

    public ListItem(String itemInit) {
        this.item = itemInit;
    }

    // Print this node
    public void printNodeData() {
        System.out.println(this.item);
    }
}
