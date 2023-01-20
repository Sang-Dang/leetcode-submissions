/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * MERGE TWO SORTED LISTS
 */

public class P0021 {

    public static class LinkedList {
        ListNode head;

        public LinkedList() {
            head = null;
        }

        public void addHead(int data) {
            if (head == null) {
                head = new ListNode(data);
            } else {
                head = new ListNode(data, head);
            }
        }

        public void addHead(int... args) {
            for(int i: args) 
                addHead(i);
        }

        public ListNode getHead() {
            return head;
        }
    }

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

    private static ListNode insertFromPosition(ListNode position, int insertVal) {
        ListNode iterator = position;
        boolean flag = false;
        while (position != null && position.val < insertVal) {
            iterator = position;
            position = position.next;
            flag = true;
        }
        if(flag == false) 
            position.next = new ListNode(insertVal,position.next);
        else 
            iterator.next = new ListNode(insertVal, position);
        return iterator.next;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode toInsert = (list1.val > list2.val) ? list1 : list2; // choose larger listnode
        ListNode returnList = (toInsert == list1) ? list2 : list1; // choose smaller listnode
        ListNode returnValue = returnList;
        while (toInsert != null) {
            returnList = insertFromPosition(returnList, toInsert.val);
            toInsert = toInsert.next;
        }
        return returnValue;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.addHead(2,2,2);
        LinkedList l2 = new LinkedList();
        l2.addHead(3,2);
        ListNode result = mergeTwoLists(l1.head, l2.head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
