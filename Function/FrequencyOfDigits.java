/*Input

986272
2
Output

2
Explanation

2 occurs 2 times in the given digit. Hence the output will be 2.*/

import java.util.*;

public class Main {

	static int FrequencyofDigits(long n, int d) {
        // write code here
        int c =0;
        while(n>0){
            long r = n %10;
            if(r==d){
                c++;
            }
            n=n/10;
        }
        return c;
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int d = sc.nextInt();
        System.out.println(FrequencyofDigits(n, d));
    }
}
