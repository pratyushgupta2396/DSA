import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = scn.nextInt();
        System.out.println("Enter the elements : ");
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println("Enter the element to be search :");
        int x = scn.nextInt();

        for(int i = 0; i < size; i++){
            if(arr[i] == x){
                System.out.println("Element found at index :" + i);
            }
        }
    }
}
