/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P0023 {
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

    // solution 1: inefficient find smallest, go next
    public ListNode findMin(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        ListNode small = null;
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                if(lists[i].val < min) {
                    small = lists[i];
                    min = small.val;
                }
            }
        }
        return small;
    }

    // public ListNode mergeKLists(ListNode[] lists) {
    //     if(lists.length == 0) {
    //         return null;
    //     }
    //     ArrayList<ListNode> result = new ArrayList<>();
    //     boolean flag = false;
    //     while(!flag) {
    //         flag = false;
    //         ListNode smallest = findMin(lists);

    //         for (int i = 0; i < lists.length; i++) {
    //             if(lists[i] != null && lists[i] == smallest) {
    //                 lists[i] = lists[i].next;
    //                 break;
    //             }
    //         }

    //         result.add(smallest);
    //         boolean nonNull = false;
    //         for (int i = 0; i < lists.length; i++) {
    //             if(lists[i] != null) {
    //                 nonNull = true;
    //                 break;
    //             }
    //         }

    //         if(!nonNull) {
    //             flag = true;
    //         }
    //     }

    //     for (int i = 0; i < result.size() - 1; i++) {
    //         result.get(i).next = result.get(i+1);
    //     }
    //     result.get(result.size() - 1).next = null; 
    //     return result.isEmpty() ? null : result.get(0);
    // }

    // solution 2: brute force into array, sort
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> list = new ArrayList<>();
        for(ListNode i: lists) {
            while(i != null) {
                list.add(i);
                i = i.next;
            }
        }

        Collections.sort(list, (l1, l2) -> {
            return Integer.valueOf(l1.val).compareTo(Integer.valueOf(l2.val));
        });

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i+1);
        }
        if(list.get(list.size() - 1) != null) 
            list.get(list.size() - 1).next = null;
        return list.isEmpty() ? null : list.get(0);
    }

    public static void main(String[] args) {
        ListNode l1_3 = new ListNode(5);
        ListNode l1_2 = new ListNode(4,l1_3);
        ListNode l1_1 = new ListNode(1,l1_2);

        ListNode l2_3 = new ListNode(4);
        ListNode l2_2 = new ListNode(3,l2_3);
        ListNode l2_1 = new ListNode(1,l2_2);

        ListNode l3_2 = new ListNode(6,null);
        ListNode l3_1 = new ListNode(2,l3_2);

        ListNode[] lists = {
            l1_1, l2_1, l3_1
        };

        ListNode iterator = new P0023().mergeKLists(lists);
        while(iterator != null) {
            System.out.print(iterator.val + " ");
            iterator = iterator.next;
        }
    }
}
