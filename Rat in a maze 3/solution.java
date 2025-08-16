public class solution {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 4;
        int[][] maze = {
            {1, 0, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 1}
        };

        printMaze(1, 1, rows, cols, "", maze);
    }

    private static void printMaze(int sr, int sc, int er, int ec, String ans, int[][] maze) {
        if(sr>er || sc>ec || sr==0 || sc==0 || maze[sr-1][sc-1] == 0 || maze[sr-1][sc-1] == -1) return;
        if(sr == er && sc == ec){
            System.out.println(ans);
            return;
        }

        maze[sr-1][sc-1] = -1;

        printMaze(sr, sc+1, er, ec, ans+"R", maze);
        printMaze(sr+1, sc, er, ec, ans+"D", maze);
        printMaze(sr, sc-1, er, ec, ans+"L", maze);
        printMaze(sr-1, sc, er, ec, ans+"U", maze);

        maze[sr-1][sc-1] = 1; // Backtracking
    }
}
