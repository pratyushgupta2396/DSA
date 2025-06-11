import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[(int)n];
        for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
        System.out.println(new Solution().maximumArea(arr, n));
	}
}

class Solution {
    public static  int[] nsl(long hist[]){
        Stack<Integer> st = new Stack<>();
        int [] ans = new int[hist.length];
        for(int i = 0; i < hist.length; i++){
            while(!st.isEmpty() && hist[st.peek()] >= hist[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public static int[] nsr(long hist[]){
        Stack<Integer> st = new Stack<>();
        int [] ans = new int[hist.length];
        for(int i = hist.length -1; i >= 0; i--){
            while(!st.isEmpty() && hist[st.peek()] >= hist[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = hist.length;
            }else{
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public static long maximumArea(long hist[], long n) {
        
    int[] left = nsl(hist);  
    int[] right = nsr(hist); 

     long maxArea = Integer.MIN_VALUE;
     //long maxArea = 0;

    for (int i = 0; i < hist.length; i++) {
        long width = right[i] - left[i] - 1;
        long area = hist[i] * width;
        maxArea = Math.max(area, maxArea);
    }

    return maxArea;
    }
}
