import java.util.*;

public class ExpressionTree {

    static class Node {
        String token;
        Node left, right;

        Node(String token) {
            this.token = token;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public Queue<String> parse(String expression) {
        Queue<String> infix = new LinkedList<>();
        StringTokenizer tokenizer = new StringTokenizer(expression, "(?<=[-+*()%/])|(?=[-+*()%/])", true);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!token.trim().isEmpty()) {
                infix.add(token.trim());
            }
        }
        return infix;
    }

    public List<String> convert(Queue<String> infix) {
        List<String> postfix = new ArrayList<>();
        Deque<String> operators = new ArrayDeque<>();

        while (!infix.isEmpty()) {
            String token = infix.poll();

            if (isInteger(token)) {
                postfix.add(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    postfix.add(operators.pop());
                }
                operators.pop();
            } else {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)
                        && !token.equals("(")) {
                    postfix.add(operators.pop());
                }
                operators.push(token);
            }
        }

        while (!operators.isEmpty()) {
            postfix.add(operators.pop());
        }

        return postfix;
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
        }
        return -1;
    }

    public void build(List<String> postfix) {
        root = buildRecursive(postfix);
    }

    private Node buildRecursive(List<String> postfix) {
        Stack<Node> stack = new Stack<>();
        for (String token : postfix) {
            if (isInteger(token)) {
                stack.push(new Node(token));
            } else {
                Node right = stack.pop();
                Node left = stack.pop();
                Node operator = new Node(token);
                operator.left = left;
                operator.right = right;
                stack.push(operator);
            }
        }
        return stack.pop();
    }

    public String prefix() {
        return prefixRecursive(root);
    }

    private String prefixRecursive(Node current) {
        if (current == null) {
            return "";
        }
        return current.token + " " + prefixRecursive(current.left) + prefixRecursive(current.right);
    }

    public String infix() {
        return infixRecursive(root);
    }

    private String infixRecursive(Node current) {
        if (current == null) {
            return "";
        }
        String result = "";
        if (isOperator(current.token)) {
            result += "(";
        }
        result += infixRecursive(current.left);
        result += current.token;
        result += infixRecursive(current.right);
        if (isOperator(current.token)) {
            result += ")";
        }
        return result;
    }

    public String postfix() {
        return postfixRecursive(root);
    }

    private String postfixRecursive(Node current) {
        if (current == null) {
            return "";
        }
        return postfixRecursive(current.left) + postfixRecursive(current.right) + current.token + " ";
    }

    public int evaluate() {
        return evaluateRecursive(root);
    }

    private int evaluateRecursive(Node current) {
        if (current == null) {
            return 0;
        }
        if (isInteger(current.token)) {
            return Integer.parseInt(current.token);
        }
        int leftValue = evaluateRecursive(current.left);
        int rightValue = evaluateRecursive(current.right);
        switch (current.token) {
            case "+":
                return leftValue + rightValue;
            case "-":
                return leftValue - rightValue;
            case "*":
                return leftValue * rightValue;
            case "/":
                if (rightValue == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return leftValue / rightValue;
            case "%":
                return leftValue % rightValue;
        }
        return 0;
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%");
    }

    public static void main(String[] args) {

        // Instantiate student code
        ExpressionTree eTree = new ExpressionTree();

        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();

        System.out.println("Original Expression: " + expression);

        // Verify parse
        Queue<String> infix = eTree.parse(expression);
        System.out.println("Infix Tokens: " + infix.toString());

        // Verify convert
        List<String> postfix = eTree.convert(infix);
        System.out.println("Postfix Tokens: " + postfix.toString());

        // Verify build
        eTree.build(postfix);
        System.out.println("Build: complete");

        // Verify prefix
        System.out.println("Prefix: " + eTree.prefix());

        // Verify infix
        System.out.println("Infix: " + eTree.infix());

        // Verify postfix
        System.out.println("Postfix: " + eTree.postfix());

        // Verify evaluate
        System.out.println("Evaluate: " + eTree.evaluate());

        // Verify display
        System.out.println("Display: complete");

        input.close();
    }

}
