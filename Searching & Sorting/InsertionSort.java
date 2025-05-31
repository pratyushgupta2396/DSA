import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        
        insertionSort(array,n);
    }
	 static void insertionSort(int arr[], int n)
    {
        //Write your code here
        for(int itr = 1; itr < arr.length; itr++){
            int i = itr;
            while(i >= 1 && arr[i-1] > arr[i]){
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
                i--;
            }
        }
        for(int i = 0;  i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
