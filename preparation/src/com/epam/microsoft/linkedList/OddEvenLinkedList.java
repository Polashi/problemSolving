package com.epam.microsoft.linkedList;

import java.util.List;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        ListNode out = oddEvenList(head);

    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (temp != null && temp.next != null){
            curr.next = new ListNode(temp.value);
            curr = curr.next;
            temp = temp.next.next;
        }
        temp = head.next;
        while (temp != null && temp.next != null){
            curr.next = new ListNode(temp.value);
            curr = curr.next;
            temp = temp.next.next;
        }

        return dummy.next;
    }
}
