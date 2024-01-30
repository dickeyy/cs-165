/**
 * Recitation created by Toby Patterson, 5/22/2020
 * For CS165 at CSU
 * With the help of
 * https://www.cs.colostate.edu/~cs165/.Spring20/recitations/L6/doc/
 *
 * NOTE: All methods should be implemented recursively, no iteration allowed!
 */

public class LinearRecursion {

    /**
     * params: integer n
     * return: n! or n * (n - 1) * (n - 2) * ... * 1
     */
    public static int factorial(int n) {

        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);

    }

    /**
     * params: integer n
     * return: n + (n - 1) + (n - 2) + ... + 1
     */
    public static int sum(int n) {

        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);

    }

    /**
     * Recursively return the sum of the harmonic series.
     * params: n a positive number.
     * return: the sum 1 + 1/2 + 1/3 + ... + 1/(n-1) + 1/n
     * 
     * The Geometric Summation will return the sum of the geometric series.
     * 
     * TO DO:
     * 1. Set up this method so that when you input an integer n the method will
     * return the sum of the sum 1 + 1/2 + 1/4 + 1/8 + ... + 1/Math.pow(2,n),
     * 
     * To understand how these methods are exhibiting linear recursion, draw out the
     * stack trace for a reasonable n value like 4. Here's an example of this for
     * factorial for n = 5:
     */
    public static double harmonicSum(int n) {

        // make sure that there isnt a stack overflow
        if (n == 0) {
            return 0;
        }

        return 1.0 / n + harmonicSum(n - 1);

    }

    /**
     * Recursively return the sum of the geometric series.
     * params: n a non-negative number.
     * return: the sum 1 + 1/2 + 1/4 + 1/8 + ... + 1/Math.pow(2,n)
     */
    public static double geometricSum(int n) {

        if (n == 0) {
            return 1;
        }
        return 1.0 / Math.pow(2, n) + geometricSum(n - 1);

    }

    public static void main(String args[]) {
        // Test code, uncomment each block as you write the functions

        System.out.println("Testing the factorial method");
        System.out.printf("factorial(4) should be 24 -> %d\n", factorial(4));
        System.out.printf("factorial(6) should be 720 -> %d\n", factorial(6));
        System.out.printf("factorial(0) should be 1 -> %d\n", factorial(0));
        System.out.println();

        System.out.println("Testing the summation method");
        System.out.printf("sum(4) should be 10 -> %d\n", sum(4));
        System.out.printf("sum(10) should be 55 -> %d\n", sum(10));
        System.out.printf("sum(0) should be 0 -> %d\n", sum(0));

        System.out.println("Testing out the harmonicSum method");
        System.out.printf("harmonicSum(0) should be 0.0000 -> %.4f\n",
                harmonicSum(0));
        System.out.printf("harmonicSum(7) should be 2.5929 -> %.4f\n",
                harmonicSum(7));
        System.out.printf("harmonicSum(8) should be 2.7179 -> %.4f\n",
                harmonicSum(8));
        System.out.printf("harmonicSum(13) should be 3.1801 -> %.4f\n",
                harmonicSum(13));
        System.out.printf("harmonicSum(24) should be 3.7760 -> %.4f\n",
                harmonicSum(24));
        System.out.println();

        System.out.println("Testing out the geometricSum method");
        System.out.printf("geometricSum(0) should be 1.0000 -> %.4f\n",
                geometricSum(0));
        System.out.printf("geometricSum(1) should be 1.5000 -> %.4f\n",
                geometricSum(1));
        System.out.printf("geometricSum(2) should be 1.7500 -> %.4f\n",
                geometricSum(2));
        System.out.printf("geometricSum(7) should be 1.9922 -> %.4f\n",
                geometricSum(7));
        System.out.printf("geometricSum(24) should be 2.0000 -> %.4f\n",
                geometricSum(24));
        System.out.println();
    }
}
