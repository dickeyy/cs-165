public class App {
    public static void main(String args[]) {
        testInsert();
        testRemoveLeaf();
        testRemoveOneChildRight();
        testRemoveOneChildLeft();
        testRemoveTwoChildrenRight();
        testRemoveTwoChildrenLeft();
        testRemove();

    }
    public static void testInsert(){
        System.out.println("Testing Insert");
        BTreeNode<Integer> tl = new BTreeNode<>(10);
        BTreeNode<Integer> tr = new BTreeNode<>(30);
        BTreeNode<Integer> root = new BTreeNode<>(20, tl, tr);
        BinarySearchTree<Integer> btree = new BinarySearchTree<>(root);
        btree.inOrderTraverse();
        System.out.println();
        System.out.println(btree.search(20).getItem());
        System.out.println(btree.search(10).getItem());
        System.out.println(btree.search(30).getItem());
        BTreeNode<Integer> ret = btree.search(40);
        if(ret == null) System.out.println("Not found!");
        btree.insert(5);
        btree.inOrderTraverse();
        System.out.println();
        btree.insert(40);
        btree.inOrderTraverse();
        System.out.println();
        btree.insert(15);
        btree.insert(25);
        btree.inOrderTraverse();
        System.out.println();

    }
    public static void testRemoveLeaf(){
        System.out.println("Remove Leaf");
        BinarySearchTree<Integer> btree = new BinarySearchTree<>();
        btree.insert(100);
        btree.insert(50);
        btree.insert(200);
        btree.inOrderTraverse();
        System.out.println();
        BTreeNode node = btree.searchRecursive(50);
        btree.removeLeaf(node);
        btree.inOrderTraverse();
        System.out.println();
        node = btree.searchRecursive(200);
        btree.removeLeaf(node);
        btree.inOrderTraverse();
        System.out.println();
        node = btree.searchRecursive(100);
        btree.removeLeaf(node);
        btree.inOrderTraverse();
        System.out.println();

    }

    public static void testRemoveOneChildRight(){
        System.out.println("Remove One Child Right");
        BinarySearchTree<Integer> btree = new BinarySearchTree<>();
        btree.insert(19);
        btree.insert(14);
        btree.insert(25);
        btree.insert(30);
        btree.inOrderTraverse();
        System.out.println();
        BTreeNode<Integer> node = btree.search(25);
        btree.removeNodeSingleChild(node);
        btree.inOrderTraverse();
        System.out.println();
    }
    public static void testRemoveOneChildLeft(){
        System.out.println("Remove One Child Left");
        BinarySearchTree<Integer> btree = new BinarySearchTree<>();
        btree.insert(19);
        btree.insert(14);
        btree.insert(25);
        btree.insert(30);
        btree.insert(4);
        btree.inOrderTraverse();
        System.out.println();
        BTreeNode<Integer> node = btree.searchRecursive(14);
        btree.removeNodeSingleChild(node);
        btree.inOrderTraverse();
        System.out.println();
    }
    public static void testRemoveTwoChildrenRight(){
        System.out.println("Remove Two Child Right");
        BinarySearchTree<Integer> btree = new BinarySearchTree<>();
        btree.insert(19);
        btree.insert(14);
        btree.insert(25);
        btree.insert(30);
        btree.insert(21);
        btree.insert(27);
        btree.insert(68);
        btree.inOrderTraverse();
        System.out.println();
        BTreeNode<Integer> node = btree.searchRecursive(25);
        btree.removeNodeTwoChildren(node);
        btree.inOrderTraverse();
        System.out.println();

    }

    public static void testRemoveTwoChildrenLeft(){
        System.out.println("Remove Two Child Left");
        BinarySearchTree<Integer> btree = new BinarySearchTree<>();
        btree.insert(19);
        btree.insert(10);
        btree.insert(5);
        btree.insert(14);
        btree.insert(12);
        btree.insert(15);
        btree.insert(25);
        btree.insert(21);
        btree.insert(30);
        btree.inOrderTraverse();
        System.out.println();
        BTreeNode<Integer> node = btree.searchRecursive(10);
        btree.removeNodeTwoChildren(node);
        btree.inOrderTraverse();
        System.out.println();

    }

    public static void testRemove(){
        System.out.println("Remove");
        BinarySearchTree<Integer> btree = new BinarySearchTree();
        btree.insert(19);
        btree.insert(10);
        btree.insert(5);
        btree.insert(14);
        btree.insert(12);
        btree.insert(15);
        btree.insert(25);
        btree.insert(21);
        btree.insert(30);
        btree.inOrderTraverse();
        System.out.println();
        System.out.println("Remove leaf 21");
        btree.remove(21);
        btree.inOrderTraverse();
        System.out.println();
        System.out.println("Remove Internal Node Two Child 10");
        btree.remove(10);
        btree.inOrderTraverse();
        System.out.println();
        System.out.println("Remove Internal Node One Child 25");
        btree.remove(25);
        btree.inOrderTraverse();
        System.out.println();
        System.out.println("Remove root");
        btree.remove(19);
        btree.inOrderTraverse();
        System.out.println();

    }
}
