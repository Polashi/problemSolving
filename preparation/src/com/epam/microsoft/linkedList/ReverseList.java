package com.epam.microsoft.linkedList;

public class ReverseList {
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
