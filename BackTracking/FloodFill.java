   // Flood Fill
import java.util.*;

public class Main {
    public static int[][] FloodFill(int[][] w, int x, int y, int c) {
        // write code here 
        boolean visited [][] = new boolean [w.length][w[0].length];
        fillColor(w, visited, w[x][y], c, x, y);
        return w;
    }

    public static void fillColor(int [][] w, boolean [][] visited, int prev, int c, int x, int y){
        if(x < 0 || x >= w.length || y < 0 || y >= w[0].length || visited[x][y] == true || w[x][y] != prev){
            return;
        }
        visited[x][y] = true;
        fillColor(w, visited, w[x][y], c, x - 1, y);
        fillColor(w, visited, w[x][y], c, x, y + 1);
        fillColor(w, visited, w[x][y], c, x + 1, y);
        fillColor(w, visited, w[x][y], c, x, y - 1);
        w[x][y] = c;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] w = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; ++j)
                w[i][j] = sc.nextInt();
        }
        int x = sc.nextInt(), y = sc.nextInt(), c = sc.nextInt();
	    FloodFill(w, x, y, c);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                System.out.print(w[i][j] + " ");
            System.out.println();
        }
    }
}
