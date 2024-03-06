import java.util.Stack;

public class Worksheet {
    /*
     * 1.
     * Infix: A + B * C + D
     * Prefix: +A+*BCD
     * Postfix: ABC*+D+
     * 
     * Infix: (A + B) * (C + D)
     * Prefix: *+AB+CD
     * Postfix: AB+CD+*
     * 
     * Infix: A * B + C * D
     * Prefix: +ABCD
     * Postfix: ABCD+
     * 
     * Infix: A + B + C + D
     * Prefix: ++++ABCD
     * Postfix: ABCD+++
     * 
     * 2.
     * 1
     * 2
     * 
     * 3. 1100
     * 
     * 4. 100
     * 25
     * 
     * 5. Write a method to check if a string is a palindrome using a stack.
     */

    public static boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            if (stack.pop() != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
