public class rat_in_maze {
    public static void main(String[] args) {
        int rows = 2;
        int cols = 3;

        int count = maze(1, 1, rows, cols);
        
        System.out.println("Total paths: " + count);

        printMaze(1, 1, rows, cols, "");

    }

    private static int maze(int sr, int sc, int er, int ec){
        if (sr == er && sc == ec) {
            return 1;
        }
        if (sr > er || sc > ec) {
            return 0;
        }
        int downWays = maze(sr+1, sc, er, ec);
        int rightWays = maze(sr, sc+1, er, ec);
        int totalWays = downWays + rightWays;
        return totalWays;
    }

    private static void printMaze(int sr, int sc, int er, int ec, String s){
        if (sr>er || sc>ec) return;
        if (sr == er && sc == ec) {
            System.out.println(s);
            return;            
        }

        printMaze(sr+1, sc, er, ec, s + "D");
        printMaze(sr, sc+1, er, ec, s + "R");
    }
}
