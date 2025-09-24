 import java.io.*;
import java.util.*;

class Solution {
    public int peakIndexInMountainArray(int[] A) {
       // Your code here.
       int low = 0;
       int high = A.length -1;
       while(low <= high){

       int mid = low + (high - low)/2;
       int prev = mid - 1 >= 0 ? A[mid - 1] : Integer.MIN_VALUE;
       int forward = mid + 1 < A.length ? A[mid + 1] : Integer.MIN_VALUE;

       if(prev < A[mid] && A[mid] < forward){
            low = mid + 1;
       }else if(prev > A[mid] && A[mid] > forward){
            high = mid - 1;
       }else{
            return mid;
       }
       }
       return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.peakIndexInMountainArray(arr1);
        System.out.print(result + " ");
        System.out.println('\n');
    }
}
