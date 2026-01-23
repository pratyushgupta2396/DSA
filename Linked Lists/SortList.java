  /**    LEETCODE -> 148

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*
Input: head = [4,2,1,3]
Output: [1,2,3,4]
*/
class Solution {
    public ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode merge2List(ListNode l1, ListNode l2){
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode head = new ListNode(-1);
        ListNode temp3 = head;
        while(temp1 != null && temp2 != null){
            if(temp1.val < temp2.val){
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

    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        left = mergeSort(left);
        right = mergeSort(right);

        return merge2List(left, right);

    }
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        return mergeSort(head);
    }
}
