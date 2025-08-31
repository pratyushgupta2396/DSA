/*
Fibonacci Series up to 10 terms:
0 1 1 2 3 5 8 13 21 34
*/
public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 10; 
        int first = 0, second = 1;

        System.out.println("Fibonacci Series up to " + n + " terms:");

        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");


            int next = first + second;
            first = second;
            second = next;
        }
    }
}
