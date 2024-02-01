import java.util.Scanner;

public class LabProgram {

    // The Fibonacci
    // sequence begins with 0
    // and then 1
    // follows.All subsequent
    // values are
    // the sum
    // of the
    // previous two,for example:0,1,1,2,3,5,8,13.
    // Complete the

    // fibonacci() method, which takes in an index, n, and returns the nth value in
    // the sequence. Any negative index values should return -1.

    // Ex: If the input is:

    // 7
    // the output is:

    // fibonacci(7) is 13
    // Note: Use recursion and DO NOT use any loops.

    public static int fibonacci(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int startNum;

        startNum = scnr.nextInt();
        System.out.println("fibonacci(" + startNum + ") is " + fibonacci(startNum));

        scnr.close();
    }
}
