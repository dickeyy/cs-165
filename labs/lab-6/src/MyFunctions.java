// make a class called MyFunctions which implements which implements the
// TestingFunctions interface.

public class MyFunctions implements TestingFunctions {

    public int greatestCommonDivisor(int a, int b) {
        if (a == 0) {
            return b;
        }
        return greatestCommonDivisor(b % a, a);
    }

    public void reverseWindow(int[] arr, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        int temp;
        while (startIndex < endIndex) {
            temp = arr[startIndex];
            arr[startIndex] = arr[endIndex - 1];
            arr[endIndex - 1] = temp;
            startIndex++;
            endIndex--;
        }
    }

}