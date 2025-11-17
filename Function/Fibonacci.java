import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{ 

	public static void fibo(int n){
		int a = 0; 
		int b = 1;
		for(int i = 1; i <= n; i++){
			System.out.print(a + " ");
			int c = a + b;
			a = b;
			b = c;
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		Scanner sc = new Scanner(System.in);
		int n = 10;
		fibo(n);
	}
}
