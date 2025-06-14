import java.util.Scanner;
public class TwoDArray{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the rows and columns os an array : ");
        int rows = scn.nextInt();
        int cols = scn.nextInt();

        int[][] arr = new int[rows][cols];
        System.out.println("Enter elements");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        System.out.println("Enter Element to be found : ");
        int x = scn.nextInt();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(arr[i][j] == x){
                    System.out.println("Elements found at index (" + i + ", " + j +")" );
                }
            }
        }

    }

    }

