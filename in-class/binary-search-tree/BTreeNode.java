public class BTreeNode<T> {
    private T item;
    private BTreeNode<T> leftChild;
    private BTreeNode<T> rightChild;

    public BTreeNode(T newItem){
        item = newItem;
        leftChild = null;
        rightChild = null;
    }

    public BTreeNode(T newItem, BTreeNode<T> left, BTreeNode<T> right){
        item = newItem;
        leftChild = left;
        rightChild = right;
    }

    public T getItem(){ return item; };
    public BTreeNode<T> getLeftChild(){ return leftChild; }
    public BTreeNode<T> getRightChild(){ return rightChild; }
    public void setItem(T item){
        this.item = item;
    }
    public void setLeftChild(BTreeNode<T> left){
        leftChild = left;
    }
    public void setRightChild(BTreeNode<T> right){
        rightChild = right;
    }

}
