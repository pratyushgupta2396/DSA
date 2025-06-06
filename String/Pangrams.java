import java.util.*;
import java.io.*;

public class Main {
     public  static void isPangram(String s)
      {
           // Your code herew
           s=s.toLowerCase();
           int c =0;
           int [] maps = new int [26];
           for(int i=0;i<s.length();i++){
               char ch = s.charAt(i);
               if(ch>= 'a' && ch<='z' ){
              int map = ch -'a';
               
              if(maps[map]==0){
               maps[map]=1;
               c++;
              }
               }
           }
           if(c==26){
               System.out.println("pangram");
           }
           else {
               System.out.println("not pangram");
           }
    }
    public static void main(String args[]) {
   Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        isPangram(s);
        
    }
}
