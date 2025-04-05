package com.epam.microsoft.linkedList;

public class ReorderList {
    public static void main(String[] args) {

    }

    // given: 1->2->3->4->5->6->7
    // output: 1->7->2->6->3->5->4
    public static void reorderList(ListNode head){
        if(head == null || head.next == null){
            return;
        }
        ListNode middle = findMiddle(head);
        ListNode second = reverse(middle);
        ListNode first = head;
        while(second != null){
            first.next = second;
            second.next = first.next;

            first = first.next;
            second = second.next;

        }
    }

    private static ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null && fast.next.next == null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head){
        ListNode prev = head;
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
