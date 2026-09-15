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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }
        if(head.next==null&&n==1){
            return null;
        }
      ListNode prev = null;
      ListNode curr = head;
      ListNode temp = head;

      

      while(n-->0){
        temp=temp.next;
      }

      if(temp==null){
        return head.next;
      }

      while(temp!=null){
        prev=curr;
        curr=curr.next;
        temp=temp.next;
      }

      prev.next=curr.next;
      curr.next=null;

      return head;
    }
}
