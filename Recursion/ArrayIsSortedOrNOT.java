import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static boolean isArraySorted(int [] arr, int index){
		if(index == arr.length-1) {
			return true;
		}
		if(arr[index] > arr[index+1]){
			return false;
		}else{
			return isArraySorted(arr, index+1);
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		int [] arr = {1,2,3,4,5,3};
		System.out.println(isArraySorted(arr, 0));
	}
}
// output: false
