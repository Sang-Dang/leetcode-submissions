/**
 * https://leetcode.com/problems/linked-list-cycle/
 * LINKED LIST CYCLE
 */

public class P0141 {
    public static class ListNode {
        int data;
        ListNode next;
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast)
                return true;
        }
        return false;
    }
}
