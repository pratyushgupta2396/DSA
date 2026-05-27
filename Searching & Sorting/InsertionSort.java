import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		int [] arr = {3,5,4,2,1};
		int n = arr.length;
		  
			for(int i = 1; i < n; i++){
				int curr = arr[i];
				int j = i-1;
				while(j >= 0 && curr < arr[j]){
					arr[j+1] = arr[j]; 7
					j--;
				}
				
				arr[j+1] = curr;
			}	
				for(int i = 0; i < n; i++){
			System.out.print(arr[i] + " ");
		}
	}
}
