// Given a circular linked list consisting of N nodes and an integer K, your task is to add the integer K at the end of the list.
import java.util.*;
import java.io.*;

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
    void add(int data){
          // write your code here
          Node newNode = new Node(data);

        
        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }

        
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        
        temp.next = newNode;
        newNode.next = head;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        LinkedList ll = new LinkedList();
        for(int i = 0; i < n; i++){
            ll.add(input.nextInt());
        }
        ll.add(input.nextInt());
        Node head = ll.head;
        do{
            System.out.print(head.data + " ");
            head = head.next;
        }while(head != ll.head);
    }
}
