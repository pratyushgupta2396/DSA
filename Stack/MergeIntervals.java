  import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[][] merge(int[][] intervals) {
      // Your code here, Print your output here
         Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Stack<int []> st = new Stack<>();
        st.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++){
            int [] interval = intervals[i];
            int st2 = interval[0];
            int en2 = interval[1];
            int st1 = st.peek()[0];
            int en1 = st.peek()[1];

            if(st2 <= en1){
                st.peek()[1] = Math.max(en1, en2);
            }else{
                st.push(interval);
            }
        } 
        int [] [] ans = new int[st.size()][2];
        for(int i = ans.length -1; i >= 0; i--){
            int [] interval = st.pop();
            ans[i] = interval;
        }
        return ans;       
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m;
        m = sc.nextInt();
        int[][] A = new int[m][2];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < 2; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        Solution Obj = new Solution();
        //Obj.merge(A);
        int[][] ans = Obj.merge(A);  // Store result

        // Print merged intervals
        for (int[] interval : ans) {
            System.out.println(interval[0] + " " + interval[1]);
        }
        
    }
}
