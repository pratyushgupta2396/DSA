import java.util.*;
import java.io.*; 

class Solution {
static int [] mergeSort(int[] arr,int l,int r){
     // Your code here
     if(l == r){
        int [] ans = new int [1];
        ans[0] = arr[l];
        return ans;
     }
     int mid = (l + r)/2;
     int [] left = mergeSort(arr, l, mid);
     int [] right = mergeSort(arr, mid + 1, r);
     int [] ans = new  int[left.length + right.length];

     int i = 0;
     int j = 0;
     int k = 0;

     while(i < left.length && j < right.length){
        if(left[i] < right[j]){
            ans[k] = left[i];
            i++;
            k++;
        }else{
            ans[k] = right[j];
            j++;
            k++;
        }
     }
     while(i < left.length){
        ans[k] = left[i];
            i++;
            k++;
     }

     while(j < right.length){
        ans[k] = right[j];
            j++;
            k++;
     }
     return ans;

        }
}
public class Main {
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[] a=new int[n];
        for(int i= 0; i < n; i++)
            a[i] = input.nextInt();
        Solution Obj = new Solution();
        a=Obj.mergeSort(a,0,n-1);
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
}
