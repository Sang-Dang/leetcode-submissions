/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * REMOVE NTH NODE FROM END OF LIST
 */
public class P0019 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 2 pass solution

    public int findLength(ListNode head) {
        ListNode iterator = head;
        int count = 0;
        while(iterator != null) {
            count++;
            iterator = iterator.next;
        }
        return count;
    }

    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     int length = findLength(head);
    //     System.out.println(length);
    //     if(n == length) {
    //         head = head.next;
    //         return head;
    //     }

    //     int position = findLength(head) - n;
    //     ListNode iterator = head;
    //     for(int i = 0; i < position - 1; i++) {
    //         iterator = iterator.next;
    //     }
    //     iterator.next = iterator.next != null ? iterator.next.next : null;
    //     return head;
    // }

    // 1 pass solution
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if(fast == null) {
            return head.next;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(10, null);
        ListNode l4 = new ListNode(5,l5);
        ListNode l3 = new ListNode(100, l4);
        ListNode l2 = new ListNode(13,l3);
        ListNode l1 = new ListNode(85,l2);

        ListNode newHead = new P0019().removeNthFromEnd(l1, 1);
        ListNode iterator = newHead;
        while(iterator != null) {
            System.out.print(iterator.val + " ");
            iterator = iterator.next;
        }

    }
}
