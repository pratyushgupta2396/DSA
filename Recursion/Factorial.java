import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{   public static int factorial(int n){
	if(n == 0 || n == 1){
		return 1;
	}
	// int fact_n_mminus1 = factorial(n-1);
	// int fact_n = n * fact_n_mminus1;
	// return fact_n;
	return n * factorial(n-1);
}
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		int n = 5;
		int ans = factorial(n);
		System.out.println("Factorial of " + n + " is :" + ans);
	}
}
