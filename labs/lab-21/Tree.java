/* Tree interface
 *  A simple tree interface of items that extend comparable */

public interface Tree<E extends Comparable<E>> {
    /* Searches the tree for element E */
    public boolean search(E e);

    /* Inserts element e into the correct position, returns false if item
     *  is already in the tree. */
    public boolean insert(E e);

    /* Deletes element e and sets pointers accordingly */
    public boolean remove(E e);

    /* Returns the size of the tree */
    public int size();

    /* Does an inorder traversal of the tree, printing each node as it gets
     *  visited. */
    public void inorder();

    /* Does a postorder traversal of the tree, printing each node as it gets
     *  visited. */
    public void postorder();

    /* Does a preorder traversal of the tree, printing each node as it gets
     *  visited. */
    public void preorder();

    /* Returns true on empty, false otherwise. */
    public boolean isEmpty();
}
