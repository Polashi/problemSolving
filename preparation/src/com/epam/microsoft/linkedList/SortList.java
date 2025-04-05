package com.epam.microsoft.linkedList;

public class SortList {
    public static ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle  = findMiddle(head);
        ListNode secondHalf = middle.next;
        ListNode left = sortList(head);
        ListNode right = sortList(secondHalf);

        return merge(left, right);
    }

    public static ListNode merge(ListNode first, ListNode second){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(first != null && second != null){
            if(first.value <= second.value){
                current.next = new ListNode(first.value);
                first = first.next;
            }else {
                current.next = new ListNode(second.value);
                second = second.next;
            }
            current = current.next;
        }
        if(first != null){
            current.next = first;
        }
        if(second != null){
            current.next = second;
        }
        return dummy.next;
    }

    private static ListNode findMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
