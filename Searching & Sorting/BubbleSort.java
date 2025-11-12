  import java.util.*;

public class Main {
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int arr[] = new int[N];
 
        // Input of array
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // bubble sort in descending order
        bubbleSort(N, arr);
        // printing array elements
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void bubbleSort(int N, int[] arr) {
        // your code here
        for(int ith=0; ith<arr.length-1; ith++){
            int rightRange = arr.length-ith-1;
            for(int i = 0; i < rightRange; i++){
                // swap
                int val1 = arr[i];
                int val2 = arr[i+1];
                if(val1 > val2){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }


            }
        }
    }
}
