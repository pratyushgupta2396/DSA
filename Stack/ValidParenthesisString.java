import java.util.*;

class Solution{
    public static boolean checkValidString(int n, String s){
        //write code here
        int leftMin = 0; 
        int leftMax = 0; 

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                if (leftMin > 0) leftMin--; 
                leftMax--;                  
            } else if (c == '*') {
                if (leftMin > 0) leftMin--; 
                leftMax++;                  
            }

            if (leftMax < 0) {
                
                return false;
    }
}
     return leftMin == 0;
    }
}


public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String s = sc.next();
        Solution obj = new Solution();
        boolean ans = obj.checkValidString(n,s);
        if(ans==true){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
