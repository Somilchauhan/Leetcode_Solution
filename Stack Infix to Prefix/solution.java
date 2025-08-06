import java.util.Stack;

public class solution {

    static String convertToPrefix(String s) {
        Stack<Character> op = new Stack<>();
        Stack<String> val = new Stack<>();

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
                val.push(num + "");
            } 
            else if (c == '(') {
                op.push(c);
            } 
            else if (c == ')') {
                while (!op.isEmpty() && op.peek() != '(') {
                    String val2 = val.pop();
                    String val1 = val.pop();
                    val.push(op.pop()+ val1 + val2);
                }
                op.pop(); // remove '('
            } 
            else if (isOperator(c)) {
                while (!op.isEmpty() && hasPrecedence(c, op.peek())) {
                    String val2 = val.pop();
                    String val1 = val.pop();
                    val.push(op.pop() + val1 + val2);
                }
                op.push(c);
            }
        }

        while (!op.isEmpty()) {
            String val2 = val.pop();
            String val1 = val.pop();
            val.push(op.pop() + val1 + val2);
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

    public static void main(String[] args) {
        String s = "6+(3-2)*6/2";
        System.out.println("The Infix String is: " + s);
        String res = convertToPrefix(s);
        System.out.println("The solution of this expression is: " + res);
    }
}