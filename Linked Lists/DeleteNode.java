import java.util.*;
import java.io.*;


public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            int x = input.nextInt();
            ll.add(x);
        }

		int size = n;
        int toRemove = input.nextInt();
        Solution s = new Solution();
        s.remove(ll, toRemove, size);
        Node curr = ll.head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}

 
class Node{
    int data;
    Node next = null;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    void add(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = new_node;
    }
}
 
class Solution {
    public static void remove(LinkedList ll, int toRemove, int size){
        // write your code here
        if(toRemove == 0){
            ll.head = ll.head.next;
            return;
        }
        Node head = ll.head;
        Node temp = head;
        int i = 0;
        while (i < toRemove - 1){
               temp = temp.next;
               i++;
        }
        temp.next = temp.next.next;
        
    }

	


	public static void printLinkedList(LinkedList ll) {
		Node temp = ll.head;
		while(temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
	}
}
