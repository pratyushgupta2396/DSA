import java.io.*;
import java.util.*;

public class Main {
	static int isPalindrome(String str)
      {
              //write code here
              str = str.toLowerCase();
              str = str.replaceAll("[^a-zA-Z0-9]","");
              for(int i=0;i<str.length()/2;i++){
                if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                    return 0;
                }
              }
              return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        int result = isPalindrome(str);
        System.out.println(result);        
    }
}
