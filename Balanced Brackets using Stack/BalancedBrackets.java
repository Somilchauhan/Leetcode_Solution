import java.util.Stack;

class BalancedBrackets {
  static boolean isBalanced(String str) {
    Stack<Character> stack = new Stack<>();
    int n = str.length();
    if (n%2 != 0) {
        return false; // If the length of the string is odd, it cannot be balanced
    }
    for(int i = 0; i<n; i++){
        char ch = str.charAt(i);
        if(ch == '('){
            stack.push(ch);
        }
        else if (ch == '{') {
            stack.push(ch);
        }
        else if(ch == '['){
            stack.push(ch);
        }
        else if (ch == ')') {
            if (stack.peek() == '(') {
                stack.pop();
            }
            else {
                return false;
            }
        }
        else if (ch == '}') {
            if (stack.peek() == '{') {
                stack.pop();
            }
            else {
                return false;
            }
        }
        else if (ch == ']') {
            if (stack.peek() == '[') {
                stack.pop();
            }
            else {
                return false;
            }            
        }
    }
    if (stack.size()>0) {
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String input = "({(]([]))})";                                         // Input Example
    System.out.println("Is the string balanced? " + isBalanced(input));  // output: false
  }
}