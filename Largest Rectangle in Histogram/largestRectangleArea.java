import java.util.*;

class largestRectangleArea {
    public int LRA(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int [] nse = new int[n];
        int [] pse = new int[n];

        nse[n-1] = n;
        stack.push(n-1);

        for(int i=n-2; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) stack.pop();
            if(stack.isEmpty()) nse[i] = n;
            else nse[i] = stack.peek();
            stack.push(i);
        }

        while(!stack.isEmpty()) stack.pop();

        pse[0] = -1;
        stack.push(0);

        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) stack.pop();
            if(stack.isEmpty()) pse[i] = -1;
            else pse[i] = stack.peek();
            stack.push(i);
        }

        int max = -1;

        for(int i = 0; i<n; i++){
            int area = (nse[i] - pse[i] - 1)*heights[i];
            if(area>max) max = area;
        }
        return max;
    }

    public static void main(String[] args) {
        largestRectangleArea lra = new largestRectangleArea();
        int[] heights = {2,1,5,6,2,3};
        System.out.println("Largest Rectangle Area: " + lra.LRA(heights)); // Output: 10
    }
}