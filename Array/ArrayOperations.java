import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
                arr[i] = scanner.nextInt();

        ArrayOperations(arr, n);
    }

    public static void ArrayOperations(int[] arr, int n) {
        // Write your code here
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
            int val = arr[i];
            if(val > max){
                max = val;
            }

        }
        int average = sum / arr.length;
        System.out.println(sum + " " + average + " " + max);
    }
}
