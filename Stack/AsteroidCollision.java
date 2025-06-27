import java.util.*;

public class Main {

    public static List<Integer> asteroidCollision(int[] asteroids) {
           // write your code here
           Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean alive = true;

            while (alive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int top = stack.peek();

                if (top < -asteroid) {
                    stack.pop(); // top explodes, continue checking
                } else if (top == -asteroid) {
                    stack.pop(); // both explode
                    alive = false;
                } else {
                    alive = false; // current asteroid explodes
                }
            }

            if (alive) {
                stack.push(asteroid);
            }
        }

        return new ArrayList<>(stack);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] asteroids = new int[n];

        for (int i = 0; i < n; i++) {
            asteroids[i] = scanner.nextInt();
        }

        List<Integer> ans = asteroidCollision(asteroids); 

        if(ans.size()==0){
             System.out.print(-1);
        }else{
              for (int asteroid : ans) {
                 System.out.print(asteroid + " ");
              }
        }
    }
}
