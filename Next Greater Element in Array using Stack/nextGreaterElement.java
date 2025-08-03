import java.util.Stack;

public class nextGreaterElement {

    public static int [] nextGreater(int[] arr){
        int n = arr.length;
        int [] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        res[n-1] = -1;
        stack.push(arr[n-1]);

        for(int i = n-2; i>=0; i--){
            while (!stack.isEmpty() && stack.peek()<arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) res[i] = -1;
            else res[i] = stack.peek();
            stack.push(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 8, 6, 3, 4};
        int[] res = nextGreater(arr);
        for(int a : arr) System.out.print(a + " ");
        System.out.println();
        for (int a : res) System.out.print(a + " ");
    }
}