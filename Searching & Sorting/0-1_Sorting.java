import java.util.*;

public class Main {
	 static int[] Sorting01(int n,int[] arr){
        // Your code here
        int countZero = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]%2==0){
                countZero++;
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(i < countZero){
                arr[i] = 0;
            }else{
                arr[i] = 1;
            }
        }
        return arr;
    }
	
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;++i){
            arr[i] = sc.nextInt();
        }
        int[] ans=Sorting01(n,arr);
        for(int i=0;i<n;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
