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
        if (root == null) return true;
        return false;
    }

    public void inOrderTraverse() {
        if (!isEmpty()) inOrderTraverse(root);
        else System.out.println("root is null");
    }

    public void inOrderTraverse(BTreeNode<T> node) {
        if (node.getLeftChild() != null) inOrderTraverse(node.getLeftChild());
        System.out.print(node.getItem() + " ");
        if (node.getRightChild() != null) inOrderTraverse(node.getRightChild());
    }

    public BTreeNode<T> search(T elem) {
        if (isEmpty()) return null;
        BTreeNode<T> current = root;
        while (current != null) {
            if (elem.compareTo(current.getItem()) == 0) return current;
            if (elem.compareTo(current.getItem()) < 0) current = current.getLeftChild();
            else current = current.getRightChild();
        }
        return null;
    }

    public boolean insert(T elem) {
        BTreeNode<T> node = new BTreeNode<>(elem);
        if (isEmpty()) {
            root = node;
            size = 1;
            return true;
        }
        BTreeNode<T> current = root;
        while (current != null) {
            if (current.getItem().compareTo(elem) == 0) return false;
            if (elem.compareTo(current.getItem()) < 0) {
                if (current.getLeftChild() == null) {
                    current.setLeftChild(node);
                    size++;
                    return true;
                }
                current = current.getLeftChild();
            } else {
                if (current.getRightChild() == null) {
                    current.setRightChild(node);
                    size++;
                    return true;
                }
                current = current.getRightChild();
            }
        }
        return false;
    }

    public BTreeNode<T> searchRecursive(T elem) {
        return searchRecursive(root, elem);
    }

    public BTreeNode<T> searchRecursive(BTreeNode<T> node, T elem) {
        if (node == null) return null;
        if (elem.compareTo(node.getItem()) == 0) return node;
        if (elem.compareTo(node.getItem()) < 0) return searchRecursive(node.getLeftChild(), elem);
        if (elem.compareTo(node.getItem()) > 0) return searchRecursive(node.getRightChild(), elem);
        return null;
    }

    public BTreeNode<T> parentRecursive(T elem) {
        return parentRecursive(root, elem);
    }

    public BTreeNode<T> parentRecursive(BTreeNode<T> parent, T elem) {
        if (parent == null) return null;
        if (
            parent.getLeftChild() != null && elem.compareTo(parent.getLeftChild().getItem()) == 0
        ) return parent;
        if (
            parent.getRightChild() != null && elem.compareTo(parent.getRightChild().getItem()) == 0
        ) return parent;
        if (elem.compareTo(parent.getItem()) < 0) return parentRecursive(
            parent.getLeftChild(),
            elem
        );
        if (elem.compareTo(parent.getItem()) > 0) return parentRecursive(
            parent.getRightChild(),
            elem
        );
        return null;
    }

    public boolean removeLeaf(BTreeNode<T> node) {
        return true;
    }

    public boolean removeNodeSingleChild(BTreeNode<T> node) {
        if (node == null) return false;
        BTreeNode<T> parent = parentRecursive(node.getItem());
        BTreeNode<T> child = node.getLeftChild();
        if (node.getRightChild() != null) child = node.getRightChild();
        if (parent == null) root = child;
        else {
            if (node.getLeftChild() != null) parent.setLeftChild(child);
            else parent.setRightChild(child);
        }
        size--;
        return true;
    }

    public boolean removeNodeTwoChildren(BTreeNode<T> node) {
        if (node == null) return false;
        //find successor (leftmost child of right subtree)
        BTreeNode<T> suc = node.getRightChild();
        while (suc.getLeftChild() != null) {
            suc = suc.getLeftChild();
        }
        //create a copy of the successor
        BTreeNodeSolution<T> copy = new BTreeNodeSolution<>(suc.getItem());
        remove(suc.getItem());
        node.setItem(copy.getItem());
        size--;
        return true;
    }

    public boolean remove(T elem) {
        return false;
    }
}
