//You are given a 2D matrix mat of size m x n. Each row of mat has elements sorted from left to right. Also the first(leftmost) element of each row is greater than the last(rightmost) element of previous row.

//You are also given an integer x, Search for this x in mat, return true if x is present in mat, else return false.


import java.util.*;

public class Main {
    /*public  booleaan findElements(int [] arr, int target){
        int low = 0;
        int high = arr.length -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                return true;
            }else if(arr[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }*/
    public static boolean SearchA2DMatrix(int[][] mat, int x) {
        //Write your code here
            // Return true or false
            int n = mat.length;
            int m = mat[0].length -1;
            int totalElements = n*m;
            int low = 0;
            int high = totalElements - 1;
            while(low <= high){
                int mid = low + (high - low)/2;
                int row = mid/m;
                int col = mid%m;
                if(mat[row][col] == x){
                    return true;
                }else if(mat[row][col] < x){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            return false;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i = 0; i< m; i++) {
            for(int j = 0; j<n; j++)
                mat[i][j] = sc.nextInt();
        }
        int x = sc.nextInt();
        if(SearchA2DMatrix(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
