import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void printFibo(int a, int b, int n){
		if(n == 0) return;
		int c = a+b;
		System.out.println(c);
		printFibo(b, c, n-1);
	}


	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = 0;
		int b = 1;
		System.out.println(a);
		System.out.println(b);
		//int n = 7;
		printFibo(a, b, n-2);
	}
}
