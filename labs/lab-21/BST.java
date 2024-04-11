/* Binary Search Tree Class
 *  A binary search tree of generic type which extends Comparable
 */

public class BST<E extends Comparable<E>> implements Tree<E> {

    private TreeNode root;
    private int size;

    public class TreeNode<E> {

        public E element;
        public TreeNode rightChild;
        public TreeNode leftChild;

        /* TODO: finish this constructor
         *  Think: what needs to be initialized, there are three member variables */
        public TreeNode(E element) {
            this.element = element;
        }
    }

    public BST() {
        this.root = null;
        size = 0;
    }

    public BST(E item) {
        this();
        insert(item);
    }

    public BST(E[] items) {
        this();
        for (E item : items) {
            insert(item);
        }
    }

    /* TODO: finish this method */
    @Override
    public boolean search(E e) {
        TreeNode current = root;
        while (current != null) {
            if (e.compareTo((E) current.element) < 0) {
                current = current.leftChild;
            } else if (e.compareTo((E) current.element) > 0) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    /* TODO: finish this method */
    @Override
    public boolean insert(E e) {
        if (root == null) {
            root = new TreeNode(e);
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (current != null) {
                if (e.compareTo((E) current.element) < 0) {
                    parent = current;
                    current = current.leftChild;
                } else if (e.compareTo((E) current.element) > 0) {
                    parent = current;
                    current = current.rightChild;
                } else {
                    return false;
                }
            }
            if (e.compareTo((E) parent.element) < 0) {
                parent.leftChild = new TreeNode(e);
            } else {
                parent.rightChild = new TreeNode(e);
            }
        }
        size++;
        return true;
    }

    /* TODO: finish this method */
    @Override
    public boolean remove(E e) {
        // Initialize parent and current nodes for traversal
        TreeNode parent = null;
        TreeNode current = root;
        // Search for the node to be removed
        while (current != null) {
            if (e.compareTo((E) current.element) < 0) {
                parent = current;
                current = current.leftChild;
            } else if (e.compareTo((E) current.element) > 0) {
                parent = current;
                current = current.rightChild;
            } else {
                break; // Node found
            }
        }
        // If the node is not found, return false
        if (current == null) {
            return false;
        }
        // Case 1: Node to be removed is a leaf
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (current == parent.leftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        // Case 2: Node to be removed has only one child
        else if (current.leftChild == null || current.rightChild == null) {
            TreeNode child = (current.leftChild != null) ? current.leftChild : current.rightChild;
            if (current == root) {
                root = child;
            } else if (current == parent.leftChild) {
                parent.leftChild = child;
            } else {
                parent.rightChild = child;
            }
        }
        // Case 3: Node to be removed has two children
        else {
            TreeNode<E> successorParent = current;
            TreeNode<E> successor = current.rightChild;
            while (successor.leftChild != null) {
                successorParent = successor;
                successor = successor.leftChild;
            }
            current.element = successor.element;
            if (successor == successorParent.leftChild) {
                successorParent.leftChild = successor.rightChild;
            } else {
                successorParent.rightChild = successor.rightChild;
            }
        }
        size--;
        return true;
    }

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

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.leftChild);
        System.out.print(root.element + " ");
        inorder(root.rightChild);
    }

    /* Does a postorder traversal of the tree, printing each visited node
     *  TODO: Complete this method
     */
    @Override
    public void postorder() {
        postorder(root);
    }

    private void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.leftChild);
        postorder(root.rightChild);
        System.out.print(root.element + " ");
    }

    /* Does a preorder traversal of the tree, printing each visited node
     *  TODO: Complete this method
     */
    @Override
    public void preorder() {
        preorder(root);
    }

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.element + " ");
        preorder(root.leftChild);
        preorder(root.rightChild);
    }

    /* Prints true on empty tree, false otherwise
     *  TODO: Complete this method
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /* Returns the root node of the tree */
    public TreeNode getRoot() {
        return root;
    }
}
