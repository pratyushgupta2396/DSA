import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[][] board = new char[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        board[i][j] = sc.next().charAt(0);
      }
    }
    sc.close();
    solveSudoku(board);
    if (isValid(board)) System.out.println(
      "correct"
    ); else System.out.println("incorrect");
  }

  public static void solveSudoku(char[][] board) {
    // your code here
  sudokuSolver(board, 0, 0);
        
    }

    public static boolean isValids(char [][] board, int row, int col, char val){
        for( int j =0; j < board[0].length; j++){
            if(board [row][j] == val){
                return false;
            }
        }
         for(int i =0; i< board.length; i++){
            if(board[i][col] == val){
                return false;
            }
         }
         int stRow = (row/3)*3;
         int stCol = (col/3)*3;

         for(int i= stRow; i < stRow + 3; i++){
            for(int j = stCol; j < stCol + 3; j++ ){
                if(board[i][j] == val){
                    return false;
                }
            }
         }
         return true;
    }

    public static boolean isValid(char[][] board) {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            char val = board[i][j];
            if (val != '.' && !isValids(board, i, j, val)) {
                return true;
            }
        }
    }
    return false;
}

    public static boolean sudokuSolver(char [][] board, int row, int col){
        if(row == board.length){
            return true;
        }
        if(col == board[0].length){
             boolean res = sudokuSolver(board, row + 1, 0);
            {
                return res;
            }
        }
        




        if(board[row][col] == '.'){
         for( char i ='1'; i <= '9'; i++){
            if(isValids(board, row, col, i) == true){
                board[row][col] = i;
               boolean res = sudokuSolver(board, row, col + 1);
               if(res == true){
                return true;
               }
               board[row][col] = '.';
             

            }
         }
        }else{
            boolean res = sudokuSolver(board, row, col + 1);
            return res;
        }
          return false;
    }

}
