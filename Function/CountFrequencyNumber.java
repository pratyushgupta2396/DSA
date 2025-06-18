/*Example 1
Input

1111221 1
Output

5
Explanation

1 occur 5 times in 1111221.*/

import java.util.*;

public class Main {

	static int countFreqDigit(int n,int d)
    {
        // write code here
        int count = 0;
        n = Math.abs(n); // in case n is -ve
        while(n > 0){
            int digit = n % 10;
            if(digit == d){
                count++;
            }
            n /= 10;
        }
        return count;
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int d= sc.nextInt();
        System.out.println(countFreqDigit(n,d));
    }
}
