import java.util.*;


public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList llist= new LinkedList(); 
        int a1=sc.nextInt();
        Node head= new Node(a1);
        llist.addToTheLast(head);
        for (int i = 1; i < n; i++) 
        {
            int a = sc.nextInt(); 
            llist.addToTheLast(new Node(a));
        }
            
        Solution A = new Solution();
        A.checkLinkedListPalindrome(llist.head);
        
    }
}

class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    
class LinkedList
{
    Node head;  
    Node tail;
    public void addToTheLast(Node node) 
    {
      if (head == null) 
      {
       head = node;
       tail = node;
      } 
      else 
      {
       tail.next = node;
       tail = node;
      }
    }
      void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
    
}

class Solution
{
    static Node reversell(Node head){
        Node curr = head;
        Node prev = null;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    static void checkLinkedListPalindrome(Node head)
    {
        //Your code here
        /*if (head == null || head.next == null) {
            System.out.print("YES");
            return;
        }*/
        Node fp = head;
        Node sp = head;

        while(fp.next != null && fp.next.next  != null){
            fp = fp.next.next;
            sp = sp.next;

        }
        Node head2 = sp.next;
        sp.next = null;
        head2 = reversell(head2);

        Node temp1 = head;
        Node temp2 = head2;

        while(temp1 != null && temp2 != null){
            if(temp1.data != temp2.data){
                System.out.print("NO");
                return;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        System.out.print("YES");
    }

    
}
