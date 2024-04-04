// ATree.java - abstract class for expression tree assignment.
// Author: Chris Wilcox
// Date:   3/19/2017
// Class:  CS165
// Email:  wilcox@cs.colostate.edu

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * Provides the Node data structure and defines the abstract methods
 * that you need to implement in ExpressionTree.java. It also has a
 * method that converts an expression tree into a format that can be
 * displayed graphically.
 *
 * @author Chris Wilcox
 *         Date: 3/19/2017 <br>
 *         Class: CS165 <br>
 *         Email: wilcox@cs.colostate.edu <br>
 */
public abstract class ZTree {

    /**
     *
     */
    public Node root;

    /**
     *
     */
    public class Node {

        /**
         *
         */
        public String token;
        /**
         *
         */
        public Node left;
        /**
         *
         */
        public Node right;

        /**
         *
         * @param value
         */
        public Node(String value) {
            this.token = value;
        }
    }

    /**
     * Parse an infix expression into an {@link ArrayList} of tokens.
     * <p>
     * Reads a string that contains an infix expression, and converts
     * it to a list of tokens. Each token is an operator, operand (integer), or
     * parentheses. We suggest using the StringTokenizer method of lexing from the
     * expressions lab, no changes should be necessary except for the addition of
     * the
     * modulo operator. The parse method should be able to handle an arbitrary
     * number
     * of white spaces in the expression. Our implementation of this method is ~8
     * lines
     * of code, including brackets but not comments or white space.
     * 
     * @param expression a valid expression
     * @return expression in infix order
     */
    public abstract Queue<String> parse(String expression);

    /**
     * Convert an infix expression into postfix order.
     * <p>
     * Converts the list of tokens from the parse method from infix to postfix,
     * using the Shunting-yard algorithm from Edsger Dijkstra, a famous computer
     * scientist, as documented <a
     * href=https://en.wikipedia.org/wiki/Shunting-yard_algorithm>here</a>.
     * Our implementation uses {@link Queue} for the queue, and {@link Deque}
     * for the stack. You may want to use the utility methods
     * {@link #isOperator(String)},
     * {@link #isInteger(String)}, and {@link #precedence(String)}.
     * <p>
     * Our implementation is ~21 lines of code.
     * 
     * @param infix expression in infix order
     * @return expression in postfix order
     */
    public abstract List<String> convert(Queue<String> infix);

    /**
     * Calls a recursive helper method to build an expression tree from a postfix
     * {@link List}.
     * 
     * @param postfix the expression tree
     */
    public abstract void build(List<String> postfix);

    /**
     * Calls a recursive helper method to traverse the expression tree in prefix
     * order and build expression.
     * 
     * @return a string representing the expression in prefix order.
     */
    public abstract String prefix();

    /**
     * Calls a recursive helper method to traverse the expression tree in infix
     * order and build the expression.
     * 
     * @return a string representing the expression infix order.
     */
    public abstract String infix();

    /**
     * Calls a recursive helper method to traverse the expression tree in postfix
     * order and build the expression.
     * 
     * @return a string representing the expression in postfix order.
     */
    public abstract String postfix();

    /**
     * Calls a recursive helper method to evaluate expression tree and return the
     * result.
     * 
     * @return the result of the expression.
     */
    public abstract int evaluate();

    /**
     * Displays the expression tree in graphical format.
     * 
     * @return a dot file representation of the tree.
     */
    public ArrayList<String> display() {

        ArrayList<String> graph = new ArrayList<>();
        graph.add("digraph BST {");
        graph.add("    ratio = 1.0;");
        graph.add("    node [style=filled]");
        graph.add("    node [fontname=Arial]");
        graph.add("    edge [arrowType=normal]");
        graph.add("    edge [fillcolor=orchid]");
        displayRecursive(root, graph, "root");
        graph.add("}");
        return graph;
    }

    /**
     *
     * @param current
     * @param graph
     * @param name
     */
    public void displayRecursive(Node current, ArrayList<String> graph, String name) {
        if ((current.left) != null)
            displayRecursive(current.left, graph, name + "L");
        if ((current.right) != null)
            displayRecursive(current.right, graph, name + "R");
        if (isOperator(current.token)) {
            String operator = current.token;
            String left = current.left.token;
            String right = current.right.token;
            if (operator.equals("%"))
                operator = "\\%";
            if (left.equals("%"))
                left = "\\%";
            if (right.equals("%"))
                right = "\\%";
            // Add node
            graph.add("    " + name + " [label=\"" + operator + "\",shape=square,fillcolor=lightskyblue]");
            graph.add("    " + name + " -> " + name + "L");
            graph.add("    " + name + " -> " + name + "R");
        } else
            graph.add("    " + name + "[label=\"" + current.token + "\",shape=circle,fillcolor=lightseagreen]");
    }

    //
    // Utility methods
    //

    /**
     * @param token a token
     * @return true if token is an operator.
     */
    public static boolean isOperator(String token) {
        switch (token) {
            case "*":
            case "/":
            case "%":
            case "+":
            case "-":
                return true;
            default:
                return false;
        }
    }

    /**
     * @param token a token
     * @return true if the token is an int.
     */
    public static boolean isInteger(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Converts an {@code String} into an {@code int}.
     * For example the string "11" is converted to the int 11.
     * 
     * @param token a string representing a number
     * @return the decimal representation if the token or -1.
     */
    public static int valueOf(String token) {
        try {
            return (Integer.parseInt(token));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Returns operator precedence.
     * 
     * @param operator the operator to evaluate
     * @return a ranking of operator precedence.
     */
    public static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 2;
            case "*":
            case "/":
            case "%":
                return 1;
            default:
                return 0;
        }
    }
}
