public class AllStar {
    public static void main(String[] args) {
        String str = "Hello";
        // split the string and print out the string with a * in between each character
        for (int i = 0; i < str.length(); i++) {
            if (i == str.length() - 1) {
                System.out.print(str.charAt(i));
            } else {
                System.out.print(str.charAt(i) + "*");
            }
        }
    }
}
