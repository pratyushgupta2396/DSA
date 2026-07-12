 /*
 Print the Number Star
      1 
     2 2 
    3 3 3  
   4 4 4 4 
  5 5 5 5 5 
 6 6 6 6 6 6 
7 7 7 7 7 7 7  
 
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
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= n-i; j++){
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
