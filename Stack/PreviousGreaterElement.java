import java.util.*;
import java.lang.*;
import java.io.*;
/*
You are given an array arr of distinct integers.Your task is to find the previous greater element for each element in the array.If previous greater doesn't exist print -1.

Input Format
First line of input contains a single integer n, the size of array.
Second line of input contains n space seperated integrs representing the elements of the array.

Output Format
Find the previous greater element for each of the element in the array.

Example 1
Input
4
10 20 30 40

Output:
-1 -1 -1 -1

Explanation:
For element 10 we not have any element in its left which is greater than 10, so we print -1, similary for 20, 30 and 40 no element is greater to the left of them.
Therefore we print -1 -1 -1 -1.
*/
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
