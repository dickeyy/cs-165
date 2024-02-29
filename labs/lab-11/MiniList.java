/**
 * MiniList Interface
 * Created by Toby Patterson 5/29/2020
 * For cs165 at CSU
 * Made using
 * https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
 * See above link for implementation details for each method
 */

public interface MiniList<E> {
    public boolean add(E item);

    public void add(int index, E element);

    public E remove();

    public E remove(int index);

    public boolean remove(E item);

    public void clear();

    public boolean contains(E item);

    public boolean equals(Object o);

    public E get(int index);

    public int indexOf(E item);

    public boolean isEmpty();

    public int size();
}