import java.util.*;

class solution {
    public static int celebrity(int mat[][]) {
        // code here
        Stack<Integer> stack = new Stack<>();
        int n = mat.length;
        for(int i = 0; i<n; i++){
            stack.push(i);
        }
        while(stack.size()>1){
            int per2 = stack.pop();
            int per1 = stack.pop();
            
            if(mat[per2][per1] == 0) stack.push(per2);
            else if(mat[per1][per2] == 0) stack.push(per1);
        }
        
        if(stack.isEmpty()) return -1;
        int k = stack.pop();
        for(int j=0; j<n; j++){
            if(k == j) continue;
            else if(mat[k][j] == 1) return -1;
        }
        for(int i = 0; i<n; i++){
            if(k == i) continue;
            else if(mat[i][k] == 0) return -1;
        }
        return k;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {0, 1, 0},
            {0, 0, 0},
            {1, 1, 0}
        };
        int result = celebrity(mat);
        System.out.println("Celebrity index: " + result);
    }
}