/*
Print Diamond Star
      * 
     * * 
    * * * 
   * * * * 
  * * * * * 
 * * * * * * 
* * * * * * * 
* * * * * * * 
 * * * * * * 
  * * * * * 
   * * * * 
    * * * 
     * * 
      * 

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
		//for each row
		for(int i = 1; i <= n; i++){
			// for spaces
			for(int j = 1; j <= n-i; j++){
				System.out.print(" ");
			}
			// for star print
			for(int j = 1; j <= i; j++){
				System.out.print("*" + " ");
			}
			System.out.println();
		}

		for(int i = n; i>= 1; i--){
			for(int j = 1; j <= n-i; j++){
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++){
				System.out.print("*" + " ");
			}
			System.out.println();
		}
	}
}
