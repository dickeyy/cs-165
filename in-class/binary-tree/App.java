public class App {
    public static void main(String args[]) {
        BTreeNode<Integer> tl = new BTreeNode<>(10);
        BTreeNode<Integer> tr = new BTreeNode<>(30);
        BTreeNode<Integer> root = new BTreeNode<>(20, tl, tr);
        BinarySearchTree<Integer> btree = new BinarySearchTree(root);
        btree.inOrderTraverse();
        System.out.println();
    }
}
