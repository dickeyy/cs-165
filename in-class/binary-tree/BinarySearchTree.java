public class BinarySearchTree<T extends Comparable<T>> {
    private BTreeNode<T> root;
    private int size = 0;

    // empty tree
    public BinarySearchTree() {
        this.root = null;
        size = 0;
    }

    // rootItem
    public BinarySearchTree(BTreeNode<T> node) {
        this.root = node;
        size = 1;
    }

    public boolean isEmpty() {
        if (root == null)
            return true;
        return false;
    }

    public void inOrderTraverse() {
        if (!isEmpty())
            inOrderTraverse(root);
        else
            System.out.println("root is null");
    }

    public void inOrderTraverse(BTreeNode<T> node) {
        if (node.getLeftChild() != null)
            inOrderTraverse(node.getLeftChild());
        System.out.print(node.getItem() + " ");
        if (node.getRightChild() != null)
            inOrderTraverse(node.getRightChild());
    }

    public BTreeNode<T> search(T key) {
        if (isEmpty())
            return null;
        BTreeNode<T> curr = root;
        while (curr != null) {
            if (key.compareTo(curr.getItem()) == 0)
                return curr;
            else if (key.compareTo(curr.getItem()) < 0)
                curr = curr.getLeftChild();
            else
                curr = curr.getRightChild();
        }
        return null;
    }

}
