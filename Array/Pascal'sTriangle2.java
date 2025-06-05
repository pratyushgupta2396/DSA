import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> triangle = pascalTriangleRow(n);
        for (int i = 0; i < triangle.size(); i++) {
            System.out.print(triangle.get(i) + " ");
        }
    }

	public static ArrayList<Integer> pascalTriangleRow(int numRows) {
        // write code here
        ArrayList<Integer> row = new ArrayList<>();
        long value = 1;
        for (int i = 0; i < numRows; i++) {
            row.add((int) value);
            value = value * (numRows - 1 - i) / (i + 1);
        }
        return row;
    }
}

