/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Input: head = [4,2,1,3]
// Output: [1,2,3,4]
class Solution {
    public ListNode getMid(ListNode head){
        ListNode fp = head;
        ListNode sp = head;
        while(fp.next != null && fp.next.next != null){
            fp = fp.next.next;
            sp = sp.next;
        }
        return sp;

    }
    public ListNode merge2Sorted(ListNode h1, ListNode h2){
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        ListNode temp1 = h1;
        ListNode temp2 = h2;
        while(temp1 != null && temp2 != null){
            if(temp1.val < temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
                temp = temp.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
                temp = temp.next;
            }
        }
        if(temp1 != null){
            temp.next = temp1;
        }
        if(temp2 != null){
            temp.next = temp2;
        }
        return dummyNode.next;
    }

    public ListNode mergeSort(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode h2 = mid.next; 
        mid.next = null;
        ListNode h1 = mergeSort(head);
        h2 = mergeSort(h2);

        return merge2Sorted(h1, h2);


    }
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        return mergeSort(head);
    }
}
