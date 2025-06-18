/*Input:

111

Output::

7

EXPLANATION:


111 is the binary representation of 7*/


import java.util.Scanner;

public class Main {
    public static long binaryToDecimal(long binaryNumber) {
              // write your code here
              int sum =0;
               int i=0;
              while(binaryNumber>0){
               
               long r = binaryNumber % 10;
                sum+= r*Math.pow(2,i);
                i++;
                binaryNumber/=10;
              }
              return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long binaryNumber = scanner.nextInt();
        System.out.println(binaryToDecimal(binaryNumber));
        scanner.close();
    }
}
