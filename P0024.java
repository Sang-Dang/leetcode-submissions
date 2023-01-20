public class P0024 {

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

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE, head);
        ListNode slow = dummy;
        ListNode fast = head;
        while(fast != null && fast.next != null) {

            ListNode temp = fast.next;
            slow.next = temp;
            fast.next = temp.next;
            slow.next.next = fast;

            if(fast.next != null) {
                fast = fast.next;
                slow = slow.next.next;
            }   
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode f5 = new ListNode(5);
        ListNode f4 = new ListNode(4, f5);
        ListNode f3 = new ListNode(3, f4);
        ListNode f2 = new ListNode(2, f3);
        ListNode f1 = new ListNode(1, f2);

        P0024 p = new P0024();
        for(ListNode i = p.swapPairs(f1); i != null; i = i.next) {
            System.out.print(i.val + " ");
        }
    }
}
