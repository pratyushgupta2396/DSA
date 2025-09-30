 /*
  Prime numbers between 1 to 100 are : 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 
*/
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		System.out.print("Prime numbers between 1 to 100 are : ");
		for(int j = 2; j <= 100; j++){
			boolean isPrime = true;

			for(int i = 2; i <= Math.sqrt(j); i++){
				if(j % i == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				System.out.print(j + " ");
			}
		}
	}
}
