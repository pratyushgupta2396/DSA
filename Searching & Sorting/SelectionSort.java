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
		
			for(int i = 0; i < n; i++){
				int smallest = i;
				for(int j = i+1; j < n; j++){
					if(arr[j] < arr[smallest]){
						smallest = j;
					}
				}
				int temp = arr[smallest];
				arr[smallest] = arr[i];
				arr[i] = temp;
			}
				for(int i = 0; i < n; i++){
			System.out.print(arr[i] + " ");
		}
	}
}
