import java.util.*;

class MinStack {
    long min;
    Stack<Long> stack = new Stack<>();

    public MinStack() {
        // constructor
    }
    
    public void push(int val) {
        long x = (long) val;
        if(stack.isEmpty()){
            stack.push(x);
            min = x;
        }
        else if(val < min){
            stack.push(2*x-min);
            min = x;
        }
        else if(x >= min){
            stack.push(x);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        else if(stack.peek() >= min) stack.pop();
        else if(stack.peek() < min){
            min = 2*min - stack.pop();
        }
    }
    
    public int top() {
        long q = stack.peek();
        if(stack.isEmpty()) return -1;
        else if(q >= min) return (int)q;
        else if(q < min) return (int)min;
        return 0;
    }
    
    public int getMin() {
        if(stack.isEmpty()) return -1;
        return (int)min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Returns -3.
        minStack.pop();
        System.out.println(minStack.top());    // Returns 0.
        System.out.println(minStack.getMin()); // Returns -2.
    }
}