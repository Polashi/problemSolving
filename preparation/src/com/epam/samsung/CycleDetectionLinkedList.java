package com.epam.samsung;

public class CycleDetectionLinkedList {
    public static ListNode detectCycle(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                removeCycle(slow, head);
                return slow;
            }
        }
        return null;
    }

    private static void removeCycle(ListNode start, ListNode head) {
        ListNode temp = start;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = null;
    }
}
