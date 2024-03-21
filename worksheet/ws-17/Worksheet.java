public class Worksheet {
    public E element() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        NodeGeneric<E> head = last.next;
        return head.getElement();
    }
}
