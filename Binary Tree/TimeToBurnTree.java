import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) arr[i] = sc.next();
    int k = sc.nextInt();
    sc.close();
    Node tree = levelOrderCreateTree(arr);
    System.out.println(timeToBurnTree(tree, k));
  }
/*
Input
7
1 2 3 null null 4 5
3
Output
2
  
Explanation
In the zeroth minute, Node 3 will start to burn.
After one minute, Nodes (1, 4, 5) that are adjacent to 3 will burn completely.
After two minutes, the only remaining Node 2 will be burnt and there will be no nodes remaining in the binary tree.
So, the whole tree will burn in 2 minutes.
*/  
  
// main code start here
   static HashMap<Node, Node> map = new HashMap<>();
    static Node infected = null;
    public static void travel(Node node, Node parent, int infectedValue){
        if(node == null){
            return;
        }
        if(node.data == infectedValue){
            infected = node;
        }
        map.put(node,parent);
        travel(node.left, node, infectedValue);
        travel(node.right, node, infectedValue);
    }
  public static int timeToBurnTree(Node root, int start) {
     
    //   Write your code here
     travel(root, null, start);
        LinkedList<Node> q = new LinkedList<>();
        q.addLast(infected);
        Set<Node> isInfected = new HashSet<>();
        int time = 0;
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                Node rem = q.removeFirst();
                isInfected.add(rem);
                if(rem.left != null && !isInfected.contains(rem.left)){
                    q.addLast(rem.left);
                }
                if(rem.right != null && !isInfected.contains(rem.right)){
                    q.addLast(rem.right);
                }
                Node parent = map.get(rem);
                if(parent != null && !isInfected.contains(parent)){
                    q.addLast(parent);
                }
            }
            time++;
        }
        return time-1;
    }
   
  

  static void createTree(Node node, int i, String[] arr) {
    if (node != null) {
      if (2 * i + 1 < arr.length) {
        if (arr[2 * i + 1].equals("null")) {
          node.left = null;
        } else {
          node.left = new Node(Integer.parseInt(arr[2 * i + 1]));
        }
        createTree(node.left, 2 * i + 1, arr);
      }
      if (2 * i + 2 < arr.length) {
        if (arr[2 * i + 2].equals("null")) {
          node.right = null;
        } else {
          node.right = new Node(Integer.parseInt((arr[2 * i + 2])));
        }
        createTree(node.right, 2 * i + 2, arr);
      }
    }
  }

  static Node levelOrderCreateTree(String[] arr) {
    if (arr.length == 0) return null;
    Node head = new Node(
      Integer.parseInt(arr[0])
    );
    createTree(head, 0, arr);
    return head;
  }
}

class Node {

  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
  }
}
