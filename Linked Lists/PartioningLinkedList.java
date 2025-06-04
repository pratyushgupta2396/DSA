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
    void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Solution {
    public void partition(Node head, int x) {
        // Your code here
        Node lessHead = new Node(0);
        Node greaterHead = new Node(0);

        Node less = lessHead;
        Node greater = greaterHead;
        while(head != null){
            if(head.data < x){
                less.next = head;
                less = less.next;
            }else{
                greater.next = head;
                greater = greater.next;
            }

        
        head = head.next;
        }
        greater.next = null;
        less.next = greaterHead.next;

        
        LinkedList list = new LinkedList();
        list.printList(lessHead.next);
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
        int x = sc.nextInt();
        Solution Ob = new Solution();
        Ob.partition(l1.head, x);
    }
}
