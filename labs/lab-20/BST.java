/* Binary Search Tree Class
 *  Made by Toby Patterson for CS165 at CSU
 *  6/25/2020
 *  A basic binary search tree of integers, without a remove method.
 */

public class BST implements Tree<Integer> {

    private TreeNode root;
    private int size;

    public class TreeNode<Integer> {

        public Integer element;
        public TreeNode rightChild;
        public TreeNode leftChild;

        /* TODO: finish this constructor
         *  Think: what needs to be initialized, there are three member variables */
        public TreeNode(Integer element) {
            this.element = element;
            this.rightChild = null;
            this.leftChild = null;
        }
    }

    public BST() {
        this.root = null;
        size = 0;
    }

    public BST(Integer item) {
        super();
        insert(item);
    }

    public BST(Integer[] items) {
        /* Insert all of items into this tree */
        for (Integer item : items) {
            insert(item);
        }
    }

    /* Does a binary search.
     *  TODO: complete this method */
    @Override
    public boolean search(Integer item) {
        TreeNode current = root;

        while (current != null) {
            if (item.compareTo((Integer) current.element) < 0) {
                current = current.leftChild;
            } else if (item.compareTo((Integer) current.element) > 0) {
                current = current.rightChild;
            } else {
                return true;
            }
        }

        return false;
    }

    /* Inserts item into tree, return false if item is already in tree.
     *  Order of the tree is: root.element > left.element &&
     *                        root.element < right.element
     *  TODO: complete this method
     */
    @Override
    public boolean insert(Integer item) {
        if (root == null) {
            root = new TreeNode(item);
            size++;
            return true;
        }

        TreeNode current = root;
        TreeNode parent = null;

        while (current != null) {
            if (item.compareTo((Integer) current.element) < 0) {
                parent = current;
                current = current.leftChild;
            } else if (item.compareTo((Integer) current.element) > 0) {
                parent = current;
                current = current.rightChild;
            } else {
                return false;
            }
        }

        if (item.compareTo((Integer) parent.element) < 0) {
            parent.leftChild = new TreeNode(item);
        } else {
            parent.rightChild = new TreeNode(item);
        }

        size++;
        return true;
    }

    // for the next lab
    //    @Override
    //    public boolean remove(Integer item) {
    //        return false;
    //    }

    /* Getter method for the size of the tree
     *  TODO: complete this method
     */
    @Override
    public int size() {
        return size;
    }

    /* Does an inorder traversal of the tree, printing each visited node
     *  TODO: Complete this method
     */
    @Override
    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.leftChild);
            System.out.print(node.element + " ");
            inorder(node.rightChild);
        }
    }

    /* Does a postorder traversal of the tree, printing each visited node
     *  TODO: Complete this method
     */
    @Override
    public void postorder() {
        postorder(root);
    }

    private void postorder(TreeNode node) {
        if (node != null) {
            postorder(node.leftChild);
            postorder(node.rightChild);
            System.out.print(node.element + " ");
        }
    }

    /* Does a preorder traversal of the tree, printing each visited node
     *  TODO: Complete this method
     */
    @Override
    public void preorder() {
        preorder(root);
    }

    private void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.element + " ");
            preorder(node.leftChild);
            preorder(node.rightChild);
        }
    }

    /* Prints true on empty tree, false otherwise
     *  TODO: Complete this method
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /* Returns the root node of the tree */
    public TreeNode getRoot() {
        return root;
    }
}
