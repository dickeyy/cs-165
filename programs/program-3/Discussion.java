public class Discussion {

    public static int compute(int i, int j) {
        // base case
        if (i < j)
            return i;
        // recursion calla
        return compute(i - j, j);
    }

    public static int compute2(int value) {
        // base case
        if (value == 0)
            return 0;
        // compute term
        int term = value;
        // recursive case
        return term + compute2(value - 2);
    }

    public static int compute3(int value) {
        // base case
        if (value == 0)
            return 0;
        // compute term
        int term = value;
        // recursive case
        return term + compute3(value - 2);
    }

    public static double compute4(double d, int n) {
        // base case
        if (n == 0)
            return 0.0;
        // compute term
        double term = d;
        // recursion call
        return term + compute4(d / 10.0, n - 1);
    }

    public static String munge(String s) {
        if (s == null || s.length() <= 1) // base case
            return s;
        else if (s.charAt(0) == s.charAt(1))
            return munge(s.substring(1, s.length()));
        else
            return s.charAt(0) + munge(s.substring(1, s.length()));
    }

    public static void convert(int number, int base) {
        int remainder = number % base;
        int quotient = number / base;
        if (quotient > 0)
            convert(quotient, base);
        System.out.print(remainder);
    }

    public static void main(String[] args) {
        System.out.println(compute(1234, 5));
        System.out.println(compute2(10));
        System.out.println(compute3(9));
        System.out.println(compute4(100.0, 6));
        System.out.println(munge("aabbccddeeff"));
        convert(13, 2);
    }

}
