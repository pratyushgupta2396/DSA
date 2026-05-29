import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		int [] arr = {23, 45, 67, 86, 2, -1, 4, 789, 32};
		int target = 83;
		int ans = linear(arr, target);
		System.out.print(ans);
	}

  
	static int linear(int arr[], int target){
		if(arr.length == 0) return -1;
		for(int index = 0; index < arr.length; index++){
			int element = arr[index];
			if(target == element){
				return index;
			}
		}
		return -1;
	}
  
}
