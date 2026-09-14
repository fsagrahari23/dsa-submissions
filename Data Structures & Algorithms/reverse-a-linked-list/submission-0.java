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
    public ListNode reverseList(ListNode head) {
        if(head==null)return null;
        ListNode temp = head;
        ListNode nextN = null;
        ListNode curr = head;

        while(temp!=null){
           temp = curr.next;
           curr.next=nextN;
           nextN=curr;
           curr=temp;
        }

        return nextN;
    }
}
