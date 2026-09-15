class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        // Reverse second half
        ListNode prev = null;
        ListNode curr = mid.next;

        // Separate first and second half
        mid.next = null;

        while (curr != null) {
            ListNode temp = curr.next;

            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // prev = head of reversed second half

        ListNode currN = head;
        curr = prev;

        // Merge
        while (curr != null) {

            ListNode nextL = currN.next;
            ListNode nextR = curr.next;

            currN.next = curr;
            curr.next = nextL;

            currN = nextL;
            curr = nextR;
        }
    }
}