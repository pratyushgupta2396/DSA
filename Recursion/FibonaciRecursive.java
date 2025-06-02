import java.util.*;
import static java.lang.Math.ceil;
 
public class Main {

	public static int fib(int n ){
        // write code here
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        int firstPrev = fib(n-1);
        int secondPrev = fib(n-2);
        return firstPrev + secondPrev;
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fib(n));
    }
}
