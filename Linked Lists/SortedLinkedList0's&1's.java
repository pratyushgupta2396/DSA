import java.util.*;

class Solution {
    static LinkedListNode sort01(LinkedListNode head){
        // Write your code here
        int count0 = 0;
        int count1 = 0;
        LinkedListNode curr =head;

        while(curr != null){
            if(curr.data == 0){
                count0++;
            }else{
                count1++;
            }
            curr = curr.next;
        }
 
        curr = head;
        while (count0-- > 0) {
            curr.data = 0;
            curr = curr.next;
        }
        while (count1-- > 0) {
            curr.data = 1;
            curr = curr.next;
        }
        return head;
   }
}

class LinkedListNode  {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data)  {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedListNode head = new LinkedListNode(sc.nextInt());
        LinkedListNode a = head;
        for(int i=1;i<n;i++) {
            LinkedListNode temp = new LinkedListNode(sc.nextInt());
            a.next = temp;
            a = temp;
        }
        LinkedListNode ans = Solution.sort01(head);
        for(int i=0;i<n;i++) {
            if(i == n-1) {
                System.out.println(ans.data);
            }
            else {
                System.out.print(ans.data + " ");
            }
            ans = ans.next;
        }
    }
}
