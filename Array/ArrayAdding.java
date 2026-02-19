    import java.util.*;

public class Main {
  static int[] calSum(int arr1[], int arr2[], int n, int m) {
    // your code here  
    int ansSize;
    if(arr1.length > arr2.length){
      ansSize = arr1.length;
    }else{
    ansSize = arr2.length;
    } 
    int [] ans = new int[ansSize];

    int i = arr1.length - 1;
    int j = arr2.length - 1;
    int k = ans.length -1;
    int carry = 0;

    while( i>= 0 || j>=0){
      int val1 = 0;
      if( i >= 0){
        val1 = arr1[i];
      }

      int val2 = 0;
      if ( j >= 0){
        val2 = arr2[j];
      }

      int sum = val1 + val2 + carry;
      int placevalue = sum%10;
      carry = sum/10;
      ans[k] = placevalue;

      i = i - 1;
      j = j - 1;
      k = k - 1;
    }

      if(carry == 0){
        return ans;
      }

      int [] ans2 = new int[ansSize + 1];
      ans2[0] = carry;

      for(i = 0; i < ans.length; i++){
        ans2[i+1] = ans[i];
      }
      return ans2;
  }

  /* Driver program to test above function */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n1 = sc.nextInt();
    int[] arr1 = new int[n1];
    for (int i = 0; i < n1; i++) arr1[i] = sc.nextInt();

    int n2 = sc.nextInt();
    int[] arr2 = new int[n2];
    for (int i = 0; i < n2; i++) arr2[i] = sc.nextInt();
    sc.close();

    int[] res = calSum(arr1, arr2, n1, n2);
    for (int i : res) System.out.println(i);
  }
}
