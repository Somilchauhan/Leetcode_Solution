import java.util.*;
class stockSpanProblem{
    public ArrayList<Integer> calculateSpan(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        
        res.add(1);
        stack.push(0);
        
        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]) stack.pop();
            if(stack.isEmpty()) res.add(i+1);
            else res.add(i-stack.peek());
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        stockSpanProblem ssp = new stockSpanProblem();
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        ArrayList<Integer> result = ssp.calculateSpan(arr);
        System.out.println("Stock Span: " + result);
    }
}