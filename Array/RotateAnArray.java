import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void reverseArray(int [] arr, int i, int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void rotateArray(int[] nums, int k) {
           // write your code here
           k = k%nums.length;
           if(k < 0){
            k = k + nums.length;
           }
           // 1st step -> Reverse whole array
           reverseArray(nums, 0, nums.length - 1);

           // 2nd step -> Reverse first k elements
           reverseArray(nums, 0, k - 1);

           // 3rd step -> Reverse last n-k elements
           reverseArray(nums, k, nums.length - 1);
    }

  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        rotateArray(arr, k);
        
        for(int num : arr){
            System.out.print(num + " "); 
        }
        
        scanner.close();
    }
}
