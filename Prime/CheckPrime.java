 /*
Input: 7
Output: 7 is a prime
*/
 
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean isPrime = true;

		if(n <= 1){
			isPrime = false;
		}else{
			for(int i = 2; i <= Math.sqrt(n); i++){
				if(n % i == 0){
					isPrime = false;
					break;
				}
			}
		}
		if(isPrime){
			System.out.print(n + " is a prime");
		}else{
			System.out.print(n + " is NOT a prime");
		}
	}
}
