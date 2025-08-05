import java.util.Stack;

public class infixEval {

    static int evaluation(String s) {
        Stack<Character> op = new Stack<>();
        Stack<Integer> val = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == ' ') {
                continue;
            }
            
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                val.push(num);
            } 
            else if (c == '(') {
                op.push(c);
            } 
            else if (c == ')') {
                while (!op.isEmpty() && op.peek() != '(') {
                    val.push(applyOp(op.pop(), val.pop(), val.pop()));
                }
                op.pop(); // remove '('
            } 
            else if (isOperator(c)) {
                while (!op.isEmpty() && hasPrecedence(c, op.peek())) {
                    val.push(applyOp(op.pop(), val.pop(), val.pop()));
                }
                op.push(c);
            }
        }

        while (!op.isEmpty()) {
            val.push(applyOp(op.pop(), val.pop(), val.pop()));
        }

        return val.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        return !((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'));
    }

    private static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': 
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "6+(3-2)*6/2";
        System.out.println("The Infix String is: " + s);
        int res = evaluation(s);
        System.out.println("The solution of this expression is: " + res);
    }
}
