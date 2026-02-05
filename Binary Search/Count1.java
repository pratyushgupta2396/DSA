 import java.util.*;

class Solution {
    static int count1(int size, int arr[]) {
        //Write your code here
        if(size == 0){
            return 0;
        }
        int low = 0;
        int high = arr.length -1;
        int  lastOneIndex = -1; 
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == 1){
                lastOneIndex = mid;
                low = mid + 1;
            }else{
                high = mid -1 ;
            }
        }
        if(lastOneIndex == -1){
            return 0;
        }
        lastOneIndex = lastOneIndex + 1; 
        return lastOneIndex;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.count1(n,array));
    }
}
