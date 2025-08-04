import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];
        int [] ans = new int[n-k+1];
        int z = 0;

        nge[n-1] = n;
        stack.push(n-1);

        for(int i=n-2; i>=0; i--){
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) stack.pop();
            if(stack.isEmpty()) nge[i] = n;
            else nge[i] = stack.peek();
            stack.push(i);
        }

        int j = 0;
        for(int i = 0; i<n-k+1; i++){
            if(j>=k+i) j = i;
            int max = nums[j];
            while(j<i+k){
                max = nums[j];
                j = nge[j];
            }
            ans[z++] = max;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result)); // Output: [3, 3, 5, 5, 6, 7]
    }
}