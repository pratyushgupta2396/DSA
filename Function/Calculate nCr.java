import java.util.*;

public class Main {

    public static long calcFac(int num){
        long fact = 1;
        for(int i = 1; i<=num; i++){
            fact = fact * i; 
        }
        return fact;
    }

    static long calculate_nCr(int n, int r) {
        // write code here
        long ncr = (calcFac(n)) / (calcFac(r) * calcFac(n-r));
        return ncr;
    }
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        long ans = calculate_nCr(n,r);
        System.out.print(ans);
    }
}
