import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println(dn);
   }
   
   public static int getValueInBase(int n, int r){
    // Your code here
    int npr = calcFac(n) / (calcFac(n-r));
    return npr;
   }
   public static int calcFac(int num){
    int fact = 1;
    for(int i = 1; i<=num; i++){
      fact = fact * i;
    }
    return fact;
   }
  }
