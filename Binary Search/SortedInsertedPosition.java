//Given a sorted array A and a target value B, return the index if the target is found. If not, print the index where it would be if it were inserted in order.

//You may assume no duplicates in the array.

import java.io.*;
import java.util.*;

public class Main {

    public static int searchInsert(int[] a, int b) {
        // Write code here
        int low = 0;
        int high = a.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(a[mid] == b){
                return mid;
            }else if(a[mid] < b){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(searchInsert(A,B));
    }
}
