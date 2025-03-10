package com.epam.google.top30.linkedList;

import com.epam.samsung.ListNode;

public class IntersectionOfLinkedList {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;

        while(tempA != tempB){
            if(tempA == null){
                tempA=headB;
            }else{
                tempA = tempA.getNext();
            }
            if(tempB == null){
                tempB = headA;
            }else {
                tempB = tempB.getNext();
            }
        }
        return tempA;
    }
}
