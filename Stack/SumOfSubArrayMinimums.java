import java.io.*;
import java.util.*;

class Solution{
	public long minSubarraySum(int n, int a[]){ 
		// write code here
        long MOD = 1_000_000_007;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && a[st.peek()] > a[i]){
               st.pop(); 
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        for(int i = n -1; i >= 0; i--){
            while(!st.isEmpty() && a[st.peek()] >= a[i]){
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

         long total = 0;
        for(int i = 0; i < n; i++){
            int leftCount = i - left[i];
            int rigthCount = right[i] - i;
            int contri = a[i] * leftCount * rigthCount;
            total = (total + contri) % MOD;
        }
        return total;
	}
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
		Solution Obj = new Solution();
        System.out.println(Obj.minSubarraySum(n,a));
    }
}
