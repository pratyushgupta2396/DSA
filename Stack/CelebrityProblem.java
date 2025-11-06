 import java.io.*;
import java.util.*; 

class Main{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M[][] = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                M[i][j] = sc.nextInt();
        System.out.println(new Solution().findCelebrity(M,N));
    } 
} 
class Solution
{ 
    int findCelebrity(int M[][], int n)
    {
        Stack<Integer> stack = new Stack<>();

        // Push all elements to stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Find the candidate for celebrity
        while (stack.size() > 1) {
            int i = stack.pop();
            int j = stack.pop();

            if (M[i][j] == 1) {
                // i knows j, so i cannot be celebrity
                stack.push(j);
            } else {
                // i does not know j, so j cannot be celebrity
                stack.push(i);
            }
        }

        int candidate = stack.pop();

        // Verify if the candidate is a celebrity
        for (int i = 0; i < n; i++) {
            if (i != candidate && (M[candidate][i] == 1 || M[i][candidate] == 0)) {
                return -1;
            }
        }

        return candidate;
    }

}
