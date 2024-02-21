public class Worksheet {

    /*
     * 1. write a generic method to exchange the position of two elements in an
     * array.
     */

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * 2. This code defines a generic class Something that acts like a dynamic
     * array. It can store elements of any type (T) and grows as needed. The add
     * method attempts to insert an element, expanding the array if full. The code
     * ensures type safety by using the generic T throughout.
     */

    /*
     * 3. The class below does not compile because the operator > is not defined for
     * the generic type T.
     */

    /*
     * 4. Yes the code compiles.
     */

    /*
     * 5. The class compiles.
     */
}
