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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode temp1 = list1;
        ListNode curr=null;
        ListNode temp2 = list2;
        ListNode newHead = null;

        while(temp1!=null&&temp2!=null){
           if(curr==null){
            if(temp1.val<temp2.val){
            curr = temp1;
            temp1=temp1.next;
           }else{
            curr = temp2;
            temp2=temp2.next;
           }
           newHead=curr;
           continue;
          }
            if(temp1.val<temp2.val){
            curr.next = temp1;
            curr=curr.next;
            temp1=temp1.next;
            }else{
            curr.next = temp2;
            curr=curr.next;
            temp2=temp2.next;
           }
        }

        while(temp1!=null){
            curr.next = temp1;
            curr=curr.next;
            temp1=temp1.next;
        }
        while(temp2!=null){
            curr.next = temp2;
            curr=curr.next;
            temp2=temp2.next;
        }

        return newHead;
    }
}