import java.io.*;
import java.util.*;


public class Main {
    public static void SecondLargest(int[] arr, int n) {
        // Write code here
        int fMax = Integer.MIN_VALUE;
        int sMax = Integer.MIN_VALUE;

        for( int i = 0; i < arr.length; i++){
            if(arr[i] > fMax){
                sMax = fMax;
                fMax = arr[i];
            }else if(arr[i] > sMax){
                sMax = arr[i];
            }
        }
        System.out.println(sMax);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        int[] arr= new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
            
        SecondLargest(arr,n);
        sc.close();
        
    }
}
