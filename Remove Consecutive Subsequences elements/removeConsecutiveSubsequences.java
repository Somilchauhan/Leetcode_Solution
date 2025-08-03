import java.util.Stack;

public class removeConsecutiveSubsequences {

    public static int [] removeConsecutive(int [] arr){
        if(arr == null || arr.length == 0){
            return new int[0]; // Return an empty array if input is null or empty
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(stack.isEmpty() || stack.peek() != arr[i]){
                stack.push(arr[i]);
            }
            else if(arr[i] == stack.peek()){
                if (i == arr.length - 1 || arr[i] != arr[i+1]) {
                    stack.pop();                  
                }
                else{
                    continue;
                }
            }
        }
        int [] result = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--){
            result[i] = stack.pop();
        }
        return result; // Return the array with consecutive duplicates removed
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 2, 3, 10, 10, 10, 4, 4, 4, 5, 7, 7, 7, 2};
        int [] res = removeConsecutive(arr);

        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}
