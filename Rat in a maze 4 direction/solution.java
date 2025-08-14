public class solution {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        boolean [][] isVisited = new boolean[rows][cols];
        
        printMaze(1, 1, rows, cols, "", isVisited);
    }

    private static void printMaze(int sr, int sc, int er, int ec, String ans, boolean[][] isVisited) {

        if (sr < 1 || sc < 1 || sr > er || sc > ec || isVisited[sr - 1][sc - 1] == true) {
            return; 
        }

        if (sr == er && sc == ec) {
            System.out.println(ans);
            return;
        }

        isVisited[sr - 1][sc - 1] = true;
        
        // Move Down
        printMaze(sr + 1, sc, er, ec, ans + "D", isVisited);
        
        // Move Right
        printMaze(sr, sc + 1, er, ec, ans + "R", isVisited);
        
        // Move Up
        printMaze(sr - 1, sc, er, ec, ans + "U", isVisited);
        
        // Move Left
        printMaze(sr, sc - 1, er, ec, ans + "L", isVisited);

        // Backtracking
        isVisited[sr - 1][sc - 1] = false;
    }
}
