import java.util.*;

public class Main {
    public static void findPosition(int a[], int n,int k)
    {
        // Write code here
        int low = 0;
        int high = a.length -1;
        int firstPosition = -1;
        int lastPosition = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(a[mid] == k){
                firstPosition = mid;
                lastPosition = mid;

                int tempLow = mid - 1;
                int tempHigh = mid + 1;

                while (tempLow >= 0 && a[tempLow] == k) {
                    firstPosition = tempLow;
                    tempLow--;
                }

                while (tempHigh < n && a[tempHigh] == k) {
                    lastPosition = tempHigh;
                    tempHigh++;
                }
                break;
            
        }else if(a[mid] < k){
            low = mid + 1;
        }else{
            high = mid -1;
        }
    }
        System.out.println(firstPosition + " " + lastPosition);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        findPosition(array,n,k);
    }
}
