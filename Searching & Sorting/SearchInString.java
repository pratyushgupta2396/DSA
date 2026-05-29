import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		String name = "Pratyush";
		char target = 't';
		System.out.print(searchInstring(name, target));

	}
	static boolean searchInstring(String name, char target){
		if(name.length() == 0){
			return false;
		}
		for(int i = 0; i < name.length(); i++){
			if(target == name.charAt(i)){
				return true;
			}
		}
		return false;
	}

}
