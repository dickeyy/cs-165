package temp.quiz;

public class Program1 {
    public static void func4(int n) {
        System.out.print(n + " ");
        if (n == 1)
            return;
        if (n % 2 == 0)
            func4(n / 2);
        else
            func4(3 * n + 1);
    }

    // public static void func5(int n) {
    // if (n == 0 || n == 1)
    // return;
    // func5(n - 2);
    // System.out.print(n + " ");
    // func5(n - 1);
    // }

    public static void func5(int n) {
        if (n == 0 || n == 1)
            return;
        func5(n - 1);
        System.out.print(n + " ");
        func5(n - 2);
    }

    public static long func2(int n) {
        if (n == 1)
            return 1;
        if (n == 0)
            return 1;
        return func2(n - 1) + func2(n - 2);
    }

    public static void main(String[] args) {
        func5(5);
    }
}
