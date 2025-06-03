import java.io.*;
import java.util.*;
 
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    void add(int data ){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node current = head;
        while(current.next !=null){
            current = current.next;
        }
        current.next = new_node;
    }
}

class Solution {
 static Node merge(Node list1, Node list2){
       // Write your code here
         Node temp1 = list1;
         Node temp2 = list2;
         Node head = new Node(-1);
         Node temp3 = head;

        while(temp1 != null && temp2 != null){
            if(temp1.data <= temp2.data){
                temp3.next = temp1;
                temp3 = temp1;
                temp1 = temp1.next;
            }else{
                temp3.next = temp2;
                temp3 = temp2;
                temp2 = temp2.next;
            }
        }
        if(temp1 == null){
            temp3.next = temp2;
        }
        if(temp2 == null){
            temp3.next = temp1;
        }
        head = head.next;
        return head;

    }
}

public class Main {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList l1= new LinkedList();
        for(int i=0;i<n;i++){
            l1.add(sc.nextInt());
        }
        int m = sc.nextInt();
        LinkedList l2 = new LinkedList();
        for(int i=0;i<m;i++){
            l2.add(sc.nextInt());
        }

        Solution Ob = new Solution();
        Node head = Ob.merge(l1.head, l2.head);
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
