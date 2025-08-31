/*

Enter a number (n): 10
Fibonacci value at position 10 is: 55

*/

import java.util.Scanner;

public class NthFibonacci {

    // Iterative method (fast & efficient)
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number (n): ");
        int n = sc.nextInt();

        int result = fibonacci(n);
        System.out.println("Fibonacci value at position " + n + " is: " + result);

        sc.close();
    }
}
