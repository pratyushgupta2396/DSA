 
import java.util.*;
import java.io.*;

class Solution{
	static void quickSort(int[] arr){
        //Write code here
        quickSortHelper(arr, 0, arr.length - 1);
    }
    static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            
            int pivotIndex = partition(arr, low, high);

            
            quickSortHelper(arr, low, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; 
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap elements
                swap(arr, i, j);
            }
        }

        
        swap(arr, i + 1, high);

        return i + 1; 
    }

    
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
		Obj.quickSort(arr);
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
        sc.close();
    }
}
