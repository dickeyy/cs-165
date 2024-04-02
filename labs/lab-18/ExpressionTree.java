import java.util.*;

public class ExpressionTree {
    private Node root;

    private static class Node {
        String token;
        Node left;
        Node right;

        Node(String value) {
            this.token = value;
        }
    }

    public Queue<String> parse(String expression) {
        Queue<String> infix = new LinkedList<>();
        StringTokenizer tokenizer = new StringTokenizer(expression, "(?<=[-+*()%/])|(?=[-+*()%/])", true);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (!token.isEmpty()) {
                infix.add(token);
            }
        }
        return infix;
    }

    public List<String> convert(Queue<String> infix) {
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        while (!infix.isEmpty()) {
            String token = infix.poll();
            if (isInteger(token)) {
                postfix.add(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.add(stack.pop());
                }
                stack.pop();
            } else if (isOperator(token)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
                    postfix.add(stack.pop());
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return postfix;
    }

    public void build(List<String> postfix) {
        Stack<Node> stack = new Stack<>();

        for (String token : postfix) {
            Node newNode = new Node(token);

            if (isOperator(token)) {
                Node rightChild = stack.pop();
                Node leftChild = stack.pop();
                newNode.right = rightChild;
                newNode.left = leftChild;
            }

            stack.push(newNode);
        }

        root = stack.pop();
    }

    public void printPostfix(Node node) {
        if (node != null) {
            printPostfix(node.left);
            printPostfix(node.right);
            System.out.print(node.token + " ");
        }
    }

    private boolean isOperator(String token) {
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

    private boolean isInteger(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
            case "%":
                return 2;
            default:
                return 0;
        }
    }

    // public static void main(String[] args) {
    // ExpressionTree eTree = new ExpressionTree();
    // Scanner input = new Scanner(System.in);
    // String expression = input.nextLine();
    // System.out.println("Original Expression: " + expression);

    // Queue<String> infix = eTree.parse(expression);
    // System.out.println("Infix Tokens: " + infix);

    // List<String> postfix = eTree.convert(infix);
    // System.out.println("Postfix Tokens: " + postfix);

    // eTree.build(postfix);
    // System.out.println("Build: complete");

    // System.out.print("Postfix Expression: ");
    // eTree.printPostfix(eTree.root);
    // }
}
