import java.util.Scanner;

public class DescendingOrder {
    // TODO: Write a void method selectionSortDescendTrace() that takes
    // an integer array and the number of elements in the array as arguments,
    // and sorts the array into descending order.
    public static void selectionSortDescendTrace(int[] numbers, int numElements) {

        int maxIndex;
        int temp;
        for (int i = 0; i < numElements - 1; i++) {
            maxIndex = i;
            for (int j = i + 1; j < numElements; j++) {
                if (numbers[j] > numbers[maxIndex]) {
                    maxIndex = j;
                }
            }
            temp = numbers[maxIndex];
            numbers[maxIndex] = numbers[i];
            numbers[i] = temp;

            for (int k = 0; k < numElements; k++) {
                System.out.print(numbers[k] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int input, i = 0;
        int numElements = 0;
        int[] numbers = new int[10];

        // TODO: Read in a list of up to 10 positive integers; stop when
        // -1 is read. Then call selectionSortDescendTrace() method.

        while (i < 10) {
            input = scnr.nextInt();
            if (input == -1) {
                break;
            }
            numbers[i] = input;
            i++;
            numElements++;
        }

        selectionSortDescendTrace(numbers, numElements);

        scnr.close();

    }
}