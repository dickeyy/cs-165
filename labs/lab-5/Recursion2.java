public class Recursion2 {
    public static void func5(int n) {
        if (n == 0 || n == 1)
            return;
        func5(n - 2);
        System.out.println(n + " ");
        func5(n - 1);
    }

    public static void main(String[] args) {
        func5(4);
    }
}
