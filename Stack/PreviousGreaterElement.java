import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static long[] prevGreater(long[] arr, int n)
    { 
        //Write code here and print output
		Stack<Long> st = new Stack<>();
		long [] ans = new long[arr.length];
		for(int i = 0; i < arr.length; i++){
			while(st.size() > 0 && st.peek() <= arr[i]){
				st.pop();
			}if(st.size() == 0){
				ans[i] = -1;
				//ans[i] = prev;
			}else{
				ans[i] = st.peek();
				//ans[i] = prev;
			}
			st.push(arr[i]);
		}
		return ans;
    } 
}
class Main {
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().prevGreater(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
	}
}
