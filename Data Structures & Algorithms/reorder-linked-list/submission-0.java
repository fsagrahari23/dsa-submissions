class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        Stack<ListNode> stack = new Stack<>();

        ListNode curr = head;

        // Put all nodes into stack
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        int size = stack.size();

        curr = head;

        // Only need to process half
        for (int i = 0; i < size / 2; i++) {

            ListNode last = stack.pop();

            last.next = curr.next;
            curr.next = last;

            curr = last.next;
        }

        // Important: terminate the list
        curr.next = null;
    }
}