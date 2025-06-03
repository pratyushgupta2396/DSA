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
    static Node insert(Node head, int n, int pos, int val) {
        if(pos == 0){
            Node nn = new Node(val);
            nn.next = head;
            head = nn;
            return head;
        }
        // Write your code here. 
        Node temp = head;
        int i = 0;
        while( i < pos -1){
            temp = temp.next;
            i++;
        }       
        Node nn = new Node(val);
        nn.next = temp.next;
        temp.next = nn;
        return head;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList list = new LinkedList();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int val = sc.nextInt();
        int pos = sc.nextInt();
        Node head = Solution.insert(list.head, n, pos, val);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
