import java.util.List;
import java.util.ArrayList;

public class GenericArrayListPt2<T> implements Comparable<Point> {

    private T[] data;
    private int size;

    /*
     * This method is mostly here for your own benefit. You may be resizing the
     * array in several places (in both of the add methods, for instance), and
     * whenever we are doing the same thing in multiple places, it's usually a
     * good idea to put it into a function, so it can be easily reused.
     *
     * This method should change the size of that data array to whatever the
     * newSize is. It should keep the original data intact as well. I recommend
     * you start by creating a totally new String[] array of the desired size,
     * then copying over the elements from the data array to this new array,
     * then when that is done, replacing the data array with the new one.
     */
    private void resizeData(int newSize) {

        // create a new array
        T[] newData = (T[]) new Object[newSize];

        // copy the elements from the data array to the new array
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        // replace the data array with the new one
        data = newData;

    }

    /*
     * Remember: An uninitialized field is a bad one. In this constructor, you
     * should initialize data and size, using the initialCapacity as the,
     * well, initial capacity of the data array.
     *
     * Consider the distinction we make between size and capacity! The capacity
     * is the size of the internal array, while the size is the amount of
     * Strings that are actually in the array.
     */
    public GenericArrayListPt2(int initialCapacity) {

        // initialize the data array to handle generic types
        data = (T[]) new Object[initialCapacity];

        // initialize the size
        size = 0;

    }

    /*
     * This method should add a string to the END of your ArrayList.
     * For instance, if there are 5 elements, this should go into index 5 (the
     * sixth spot).
     */
    public void add(T str) {

        // increase the size
        size++;

        // check if the array is full
        if (size == data.length) {
            resizeData(data.length * 2);
        }

        // add the string at the end
        data[size - 1] = str;

    }

    /*
     * This method should add a string to a specific index in your ArrayList.
     *
     * The index may not be valid. For instance, calling this with an index of
     * 10 on an ArrayList that only has 7 elements is not allowed.
     * If the index is out of bounds, stop the method without doing anything.
     */
    public void add(int index, T str) {

        // check if the index is valid
        if (index < 0 || index > size) {
            return;
        }

        // increase the size
        size++;

        // check if the array is full
        if (size == data.length) {
            resizeData(data.length * 2);
        }

        // add the string at the index
        for (int i = size - 1; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = str;

    }

    /*
     * This method should return the string stored at a certain index.
     * Like the method above, the index may not be valid. Return null if the
     * index given is out of bounds.
     */
    public T get(int index) {

        // check if the index is valid
        if (index < 0 || index >= size) {
            return null;
        }

        return data[index];

    }

    /*
     * This method should take the string at a given index out of your
     * ArrayList.
     * If the index isn't valid, then stop the method without doing anything.
     */
    public void remove(int index) {

        // check if the index is valid
        if (index < 0 || index >= size) {
            return;
        }

        // remove the string at the index
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        // decrease the size
        size--;

    }

    /*
     * This method should return how many elements are in your ArrayList.
     * Hint: You should already be storing this in a variable called size.
     */
    public int size() {

        return size;

    }

    /*
     * This method should return true if the given string is in your ArrayList,
     * and false otherwise.
     * Remember to use .equals() instead of == when comparing one String
     * with another.
     */
    public boolean contains(String str) {

        // check if the string is in the list
        // loop through the list and check if the string is in the list
        for (int i = 0; i < size; i++) {
            if (data[i].equals(str)) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {

        /*
         * PART 2:
         * Now, modify your GenericArrayList again so that it can only store
         * things that are comparable to a Point.
         *
         * If you don't know how to do this, reference zybooks and your textbook
         * for help.
         *
         * When you are ready to test it, uncomment the code above and run the
         * code below.
         */

        GenericArrayListPt2<Point> pointList = new GenericArrayListPt2<Point>(2);
        GenericArrayListPt2<Point3D> pointList3D = new GenericArrayListPt2<Point3D>(3);

        pointList.add(new Point(0, 0));
        pointList.add(new Point(2, 2));
        pointList.add(new Point(7, 0));
        pointList.add(new Point(19.16f, 22.32f));

        pointList3D.add(new Point3D(1.0f, 2.0f, 3.0f));
        pointList3D.add(new Point3D(7.3f, 4, 0));

        Point p = pointList.get(2);
        Point3D p3 = pointList3D.get(0);

        // You should get a compilation error on this line! - Why?
        // GenericArrayListPt2<Float> floatList = new GenericArrayList<Float>(2);

    }

    @Override
    public int compareTo(Point o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

}