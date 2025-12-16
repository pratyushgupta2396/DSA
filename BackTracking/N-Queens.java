 import java.util.*;

public class Main {
    public static int totalNQueens(int n) {
        // write code here
        // Initialize arrays to track column, diagonal, and anti-diagonal attacks
        boolean[] cols = new boolean[n];
        boolean[] diag = new boolean[2 * n - 1];
        boolean[] antiDiag = new boolean[2 * n - 1];

        return solve(0, n, cols, diag, antiDiag);
    }

    private static int solve(int row, int n, boolean[] cols, boolean[] diag, boolean[] antiDiag) {
        
        if (row == n) return 1;

        int count = 0;
        for (int col = 0; col < n; col++) {
            int diagIndex = row - col + n - 1;
            int antiDiagIndex = row + col;

            if (cols[col] || diag[diagIndex] || antiDiag[antiDiagIndex]) continue;

            cols[col] = true;
            diag[diagIndex] = true;
            antiDiag[antiDiagIndex] = true;

          
            count += solve(row + 1, n, cols, diag, antiDiag);

            cols[col] = false;
            diag[diagIndex] = false;
            antiDiag[antiDiagIndex] = false;
        }

        return count;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    
        System.out.println(totalNQueens(n));
    }
}
