import java.io.*;
import java.util.*;
public class Main {
  public static int multiplyRecursively(int n, int m) {
    //Write code here and print output
    if(m==0){
      return 0 ;
    }
    int k = n+multiplyRecursively(n,m-1);
    return k;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
   int c = multiplyRecursively(n, m);
   System.out.println(c);
  }
}
