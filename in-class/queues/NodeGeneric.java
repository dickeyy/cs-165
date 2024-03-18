public class NodeGeneric<E> {
    private E element;
    private NodeGeneric<E> next;
    public NodeGeneric(E element){
        this.element = element;
        this.next = null;
    }

    public NodeGeneric(E element, NodeGeneric<E> next){
        this.element = element;
        this.next = next;
    }
    public void setNext(NodeGeneric<E> next) {
        this.next = next;
    }
    public NodeGeneric<E> getNext() {
        return next;
    }
    public E getElement() {
        return element;
    }
    public void setElement(E element){
        this.element = element;
    }
}
