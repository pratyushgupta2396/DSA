 
import java.util.*;
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Main {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        int a1 = sc.nextInt();
        Node head = new Node(a1);
        addToTheLast(head);

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            addToTheLast(new Node(a));
        }

        Solution abc=new Solution();
        Node node = abc.quickSort(head);

        printList(node);
        System.out.println();
    
        sc.close();
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
}

class Solution {
    
    public  Node quickSort(Node head)
    {
        //Your code here
        
     // If the list is empty or has only one element, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Partition the list around the pivot
        Node[] partitioned = partition(head);
        Node left = partitioned[0];
        Node pivot = partitioned[1];
        Node right = partitioned[2];

        // Recursively sort the left and right parts
        left = quickSort(left);
        right = quickSort(right);

        // Connect the three parts: left -> pivot -> right
        return concatenate(left, pivot, right);
    }

    // Partition the list into three parts: < pivot, pivot, > pivot
    private Node[] partition(Node head) {
        Node pivot = head;
        Node curr = head.next;
        pivot.next = null;

        Node lessHead = null, lessTail = null;
        Node greaterHead = null, greaterTail = null;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = null;
            if (curr.data < pivot.data) {
                if (lessHead == null) {
                    lessHead = lessTail = curr;
                } else {
                    lessTail.next = curr;
                    lessTail = curr;
                }
            } else {
                if (greaterHead == null) {
                    greaterHead = greaterTail = curr;
                } else {
                    greaterTail.next = curr;
                    greaterTail = curr;
                }
            }
            curr = nextNode;
        }

        return new Node[]{lessHead, pivot, greaterHead};
    }

    // Concatenate three lists: left, pivot, right
    private Node concatenate(Node left, Node pivot, Node right) {
        if (left == null) {
            pivot.next = right;
            return pivot;
        } else {
            Node temp = left;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = pivot;
            pivot.next = right;
            return left;
        }
    }

}
