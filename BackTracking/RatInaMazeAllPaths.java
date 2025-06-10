import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        // Write your code here
        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();

        
        int[][] visited = new int[n][n];

     
        int[][] path = new int[n][n];

       
        solveMaze(maze, 0, 0, path, visited, n, allPaths);
        
        return allPaths;
    }

    public static void solveMaze(int[][] maze, int x, int y, int[][] path, int[][] visited, int n, ArrayList<ArrayList<Integer>> allPaths) {
        
        if (x == n - 1 && y == n - 1) {
            path[x][y] = 1; 
            ArrayList<Integer> currentPath = new ArrayList<>();
            
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    currentPath.add(path[i][j]);
                }
            }
            allPaths.add(currentPath);
            
           
            path[x][y] = 0;
            return;
        }

        
        if (x < 0 || y < 0 || x >= n || y >= n || maze[x][y] == 0 || visited[x][y] == 1) {
            return;
        }

       
        visited[x][y] = 1;
        path[x][y] = 1;

       
        solveMaze(maze, x - 1, y, path, visited, n, allPaths); // Up
        solveMaze(maze, x + 1, y, path, visited, n, allPaths); // Down
        solveMaze(maze, x, y - 1, path, visited, n, allPaths); // Left
        solveMaze(maze, x, y + 1, path, visited, n, allPaths); // Right

        
        path[x][y] = 0;
        visited[x][y] = 0;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] maze = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++){
                maze[i][j] = sc.nextInt();
            }
        }
        ArrayList<ArrayList<Integer>> ans = Solution.ratInAMaze(maze, n);
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
