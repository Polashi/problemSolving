package com.epam.microsoft.linkedList;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        int size = getSize(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        for(int i=0; i<size-n; i++){
            curr = curr.next;
        }

        if(curr.next != null){
            curr.next = curr.next.next;
        }
        return dummy.next;
    }

    private int getSize(ListNode head){
        if(head == null){
            return 0;
        }
        int count = 0;
        while(head != null){
            count ++;
            head = head.next;
        }
        return count;
    }
}
